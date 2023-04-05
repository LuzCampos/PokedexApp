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
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.presentation.componentes.floatingbutton.MultiFloatingButton
import com.myprojects.pokedexapp.presentation.componentes.PokedexGrid
import com.myprojects.pokedexapp.presentation.componentes.floatingbutton.FabItem
import com.myprojects.pokedexapp.presentation.componentes.floatingbutton.MultiFloatingState
import com.myprojects.pokedexapp.presentation.componentes.floatingbutton.items
import com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet.*
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen( navController: NavController, homeViewModel: HomeViewModel){

   // val uiState by homeViewModel.uiState.observeAsState()

    var multiFloatingState by remember {
        mutableStateOf(MultiFloatingState.Collapsed)
    }

    val context = LocalContext.current

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
                    type = types,
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
                                Text(text = gen.number)
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
                    onClick3 = {
                        currentBottomSheet = BottomSheetType.TYPE3
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


