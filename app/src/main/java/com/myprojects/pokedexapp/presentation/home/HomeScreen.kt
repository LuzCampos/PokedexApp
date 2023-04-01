package com.myprojects.pokedexapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.myprojects.pokedexapp.PokedexScreenState
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.presentation.componentes.floatingbutton.MultiFloatingButton
import com.myprojects.pokedexapp.presentation.componentes.PokedexGrid
import com.myprojects.pokedexapp.presentation.componentes.floatingbutton.FabItem
import com.myprojects.pokedexapp.presentation.componentes.floatingbutton.MultiFloatingState
import com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet.BottomSheetType
import com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet.Generation
import com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet.SheetLayout
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen( navController: NavController, homeViewModel: HomeViewModel){

    val uiState by homeViewModel.uiState.observeAsState()

    var multiFloatingState by remember {
        mutableStateOf(MultiFloatingState.Collapsed)
    }

    val context = LocalContext.current

    var items = listOf(
        FabItem(
            icon = ImageBitmap.imageResource(id = R.drawable.favorite),
            label = "Favorite Pokemon",
            identifier = BottomSheetType.TYPE1.name
        ),
        FabItem(
            icon = ImageBitmap.imageResource(id = R.drawable.pokeballicon),
            label = "All Type",
            identifier = BottomSheetType.TYPE1.name
        ),
        FabItem(
            icon = ImageBitmap.imageResource(id = R.drawable.pokeballicon),
            label = "All Gen",
            identifier = BottomSheetType.TYPE3.name
        )
    )

    var generations = listOf(
        Generation(icon = ImageBitmap.imageResource(id = R.drawable.generation1), label = "Generation I","I"),
        Generation(icon = ImageBitmap.imageResource(id = R.drawable.generation2), label = "Generation II","II"),
        Generation(icon = ImageBitmap.imageResource(id = R.drawable.generation3), label = "Generation III","III"),
        Generation(icon = ImageBitmap.imageResource(id = R.drawable.generation4), label = "Generation IV","IV"),
        Generation(icon = ImageBitmap.imageResource(id = R.drawable.generation5), label = "Generation V","V"),
        Generation(icon = ImageBitmap.imageResource(id = R.drawable.generation6), label = "Generation VI","VI"),
        Generation(icon = ImageBitmap.imageResource(id = R.drawable.generation7), label = "Generation VII","VII"),
        Generation(icon = ImageBitmap.imageResource(id = R.drawable.generation8), label = "Generation VIII","VIII"),
    )

    val searchText = remember { mutableStateOf("") }

    var currentBottomSheet: BottomSheetType? by remember{
        mutableStateOf(null)
    }

    val modalBottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden
    )

    val scope = rememberCoroutineScope()

    val closeSheet = {
        scope.launch { modalBottomSheetState.hide() }
    }

    val openSheet = {
        scope.launch { modalBottomSheetState.show() }
    }

    val pokemonesLista: List<PokemonEntity> by homeViewModel.pokemonesLista.observeAsState(initial = listOf())

    ModalBottomSheetLayout(
        modifier = Modifier
            .fillMaxSize()
            .defaultMinSize(minHeight = 200.dp),
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            Spacer(modifier = Modifier.height(1.dp))
            currentBottomSheet?.let {
                SheetLayout(
                    bottomSheetType = it,
                    closeSheet = {closeSheet()},
                    searchText = searchText,
                    homeViewModel = homeViewModel,
                    generation = generations,
                    fabItemState = multiFloatingState
                )
            }
        }
    ){
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        LazyRow() {
                            items(items = generations){
                                    gen -> Button(onClick = { homeViewModel.getPokemonByGeneration(gen.number) }) {
                                Text(text = "${gen.number}")
                            }
                            }
                        }
                        //Spacer(modifier = Modifier.fillMaxSize())
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            homeViewModel.getPokemons()
                        }) {
                            Icon(
                                Icons.Filled.ArrowBack, tint = Color.Black, contentDescription = "backIcon"
                            )
                        }
                    }
                )
            },
            floatingActionButton =
            {
                MultiFloatingButton(
                    multiFloatingState = multiFloatingState,
                    onMultiFabStateChange = {
                        multiFloatingState = it
                    },
                    items = items,
                    context = context,
                    onClick1 = {
                        currentBottomSheet = BottomSheetType.TYPE1
                        openSheet()
                    },
                    onClick2 = {
                        currentBottomSheet = BottomSheetType.TYPE2
                        openSheet()
                    },
                )
            },
            content = {
               PokedexGrid(pokemonesLista = pokemonesLista, modifier = Modifier.padding(it), navController = navController)
            }
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Screen1(closeSheet : () -> Unit, searchText:MutableState<String>, homeViewModel: HomeViewModel, fabItemState: MultiFloatingState) {

    val showKeyboard = remember { mutableStateOf(true) }
    val focusRequester = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xffF1F1F1),
                    cursorColor = Color(0xffA4A7AB),
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.searchicon),
                        contentDescription = "",
                        tint = Color(0xff303943),
                        modifier = Modifier
                            .size(20.dp)
                            .padding(start = 4.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                value = searchText.value,
                onValueChange = { searchText.value = it; homeViewModel.searchPokemonByName(it) },
                placeholder = { Text("Search Pokemon, Move, Ability etc", color = Color(0xffA4A7AB), fontSize = 14.sp, fontWeight = FontWeight.Bold) }
            )

            LaunchedEffect(focusRequester) {
                if (showKeyboard.value) {
                    focusRequester.requestFocus()
                    delay(100)
                    keyboard?.show()
                }
            }
        }
    }
}

@Composable
fun PokedexSuccess(pokemons: List<PokemonEntity>, modifier: Modifier = Modifier,navController: NavController) {
    PokedexGrid(pokemonesLista = pokemons, modifier,navController)
}

@Composable
fun PokedexError(tryAgain: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .semantics {
                contentDescription = "Error"
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(R.drawable.meowth),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(.4f)
        )
        Text(stringResource(id = R.string.msg_error_generic))
        TextButton(onClick = {  }) {
            Text(stringResource(id = R.string.msg_try_again))
        }

    }
}

@Composable
fun PokedexLoading(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .semantics { contentDescription = "Loading Indicator" }
    ) {
        CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}


