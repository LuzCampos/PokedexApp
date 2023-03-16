package com.myprojects.pokedexapp.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.presentation.componentes.PokedexGrid

@Composable
fun HomeScreen( navController: NavController ,homeViewModel: HomeViewModel){

    val pokemonesLista: List<PokemonEntity> by homeViewModel.pokemonesLista.observeAsState(initial = listOf())
    println(pokemonesLista.size)
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
        }
    ) {
        if (pokemonesLista.isNotEmpty()){
            PokedexGrid(pokemonesLista = pokemonesLista, modifier = Modifier.padding(it), navController = navController)
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "No pokemons yet.",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


