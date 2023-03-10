package com.myprojects.pokedexapp.ui.theme.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.pokedexapp.data.PokemonEntity

@Composable
fun HomeScreen(homeViewModel: HomeViewModel){

    homeViewModel.getPokemons()

    val pokemonesLista: List<PokemonEntity> by homeViewModel.pokemonesLista.observeAsState(initial = listOf())
    println(pokemonesLista.size)
    if (pokemonesLista.isNotEmpty()){
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(pokemonesLista.size) { index ->
                val pokemon = pokemonesLista[index]
                println(pokemon.english_name)
                Text(text = "${pokemon.english_name}\",\"${pokemon.gen}")
            }
        }
    }else {
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


