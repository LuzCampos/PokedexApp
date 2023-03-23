package com.myprojects.pokedexapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.navigation.NavController
import com.myprojects.pokedexapp.PokedexScreenState

import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.presentation.componentes.PokedexGrid
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel


@Composable
fun HomeScreen( navController: NavController, homeViewModel: HomeViewModel){

    val uiState by homeViewModel.uiState.observeAsState()

    val pokemonesLista: List<PokemonEntity> by homeViewModel.pokemonesLista.observeAsState(initial = listOf())
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Spacer(modifier = Modifier.fillMaxSize())
                }, navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.ArrowBack, tint = Color.Black, contentDescription = "backIcon"
                        )
                    }
                }, backgroundColor = Color.White, actions = {
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.List, contentDescription = null, tint = Color.Black)
                    }
                })
        }, content = {
            when(uiState){
                is PokedexScreenState.Loading -> {
                    Box() {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                  //  PokedexLoading(modifier = Modifier.padding(it))
                }
                is PokedexScreenState.Error ->
                {
                    val errorMessage = (uiState as PokedexScreenState.Error).message
                    PokedexError(
                        errorMessage,
                        modifier = Modifier.padding(it)
                    )
                }
                is PokedexScreenState.Success ->
                {
                    val items = (uiState as PokedexScreenState.Success).pokemons
                    PokedexSuccess(
                        pokemons = items,
                        modifier = Modifier.padding(it) ,
                        navController = navController)
                }

            }
           // PokedexGrid(pokemonesLista = pokemonesLista, modifier = Modifier.padding(it),navController)
        }
        /*        when(screenState){
                    is PokedexScreenState.Loading -> PokedexLoading(modifier = Modifier.padding(it))
                    is PokedexScreenState.Error -> PokedexError(
                        screenState.tryAgain,
                        modifier = Modifier.padding(it)
                    )
                    is PokedexScreenState.Success -> PokedexSuccess(
                        pokemons = screenState.pokemons,
                        modifier = Modifier.padding(it) ,
                        navController = navController)
                }
        }*/
    )

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


