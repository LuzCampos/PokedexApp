package com.agileapps.pokedex.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.agileapps.pokedex.R
import com.agileapps.pokedex.presentation.componentes.modalbottomsheet.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.agileapps.pokedex.data.PokemonEntity
import com.agileapps.pokedex.presentation.common.CustomAppBar
import com.agileapps.pokedex.presentation.common.PokeBallBackground
import com.agileapps.pokedex.presentation.common.SearchComponent
import com.agileapps.pokedex.presentation.componentes.PokedexGrid
import com.agileapps.pokedex.presentation.componentes.floatingbutton.MultiFloatingButton
import com.agileapps.pokedex.presentation.componentes.floatingbutton.MultiFloatingState
import com.agileapps.pokedex.presentation.componentes.floatingbutton.items
import com.agileapps.pokedex.presentation.componentes.modalbottomsheet.BottomSheetType
import com.agileapps.pokedex.presentation.componentes.modalbottomsheet.SheetLayout
import com.agileapps.pokedex.presentation.componentes.modalbottomsheet.generation.generations
import com.agileapps.pokedex.presentation.home.type.types
import com.agileapps.pokedex.presentation.viewmodels.HomeViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel(),isDarkTheme : Boolean){

    var multiFloatingState by remember { mutableStateOf(MultiFloatingState.Collapsed) }
    val searchText = remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    val backgroundColor = if (isDarkTheme) Color(0xff121212) else Color.Transparent

    val backgroundColorPokeball = if (isDarkTheme) Color(0xffFFFFFF) else Color(0xff303943)

    val pokemonesLista: List<PokemonEntity> by homeViewModel.pokemonesLista.observeAsState(initial = listOf())

    val modalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    val closeSheet = { scope.launch { modalBottomSheetState.hide() } }
    val openSheet = { scope.launch { modalBottomSheetState.show() } }

    var currentBottomSheet: BottomSheetType? by remember{ mutableStateOf(null) }

    ModalBottomSheetLayout(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(0.6f),
        //.defaultMinSize(minHeight = 200.dp),
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            Spacer(modifier = Modifier
                .height(1.dp)
                .background(backgroundColor))
            currentBottomSheet?.let {
                SheetLayout(
                    bottomSheetType = it,
                    searchText = searchText,
                    homeViewModel = homeViewModel,
                    generation = generations,
                    type = types,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(backgroundColor)
                        .padding(horizontal = 26.dp)
                        .padding(top = 30.dp, bottom = 13.dp),
                    closeSheet = { closeSheet() }
                )
            }
        }
    ){
        Box (modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor))
        {
            Scaffold(
                backgroundColor = backgroundColor,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(horizontal = 8.dp),
                topBar = {
                    CustomAppBar(onClick = {homeViewModel.getPokemons()
                        //navController.popBackStack()
                        },
                        tint = MaterialTheme.colors.onSecondary )
                },
                floatingActionButton =
                {
                    MultiFloatingButton(
                        multiFloatingState = multiFloatingState,
                        onMultiFabStateChange = {
                            multiFloatingState = it
                        },
                        items = items,
                        onClick = { selectedBottomSheetType ->
                            currentBottomSheet = selectedBottomSheetType
                            openSheet()
                        }
                    )
                },
                content = {
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .padding(it)
                    ) {
                            SearchComponent(searchText = searchText, homeViewModel = homeViewModel ,
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp).padding(bottom = 20.dp)
                                    //.height(50.dp)
                            )
                        PokedexGrid(
                            pokemonesLista = pokemonesLista,
                            modifier = Modifier.fillMaxWidth().padding(it)
                            //.height(200.dp)
                            ,
                            navController = navController
                        )

                    }
                }
            )
            PokeBallBackground(backgroundColorPokeball)
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


