package com.myprojects.pokedexapp.presentation.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.myprojects.pokedexapp.presentation.common.PokeballImageCard
import com.myprojects.pokedexapp.presentation.common.PokemonImage
import com.myprojects.pokedexapp.presentation.common.TitleHeader

@Composable
fun CaptureYourFirstPokemon() {
    PokedexGridView(pokemons = pokemones)
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PokedexGridView(pokemons : List<Pokemon>){
    Column(
        modifier = Modifier.height(400.dp),
    ) {
        TitleHeader(text = "Capture Your First Pokemon", modifier = Modifier)
        FlowRow(
            modifier = Modifier.padding(top = 26.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            pokemons.forEach { item ->
                PokedexCardView(pokemon = item)
            }
        }
    }
}

@Composable
fun PokedexCardView(pokemon: Pokemon){
    Card(
        modifier = Modifier
            .size(140.dp)
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = 10.dp,
        backgroundColor = Color(0xff48D0B0)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.36f)
        ) {
            PokeballImageCard(Modifier.align(Alignment.Center))
            PokemonImage(pokemon.drawableResourceId,
                Modifier
                    .align(Alignment.Center)
                    .padding(end = 10.dp, bottom = 10.dp))
        }
    }
}

