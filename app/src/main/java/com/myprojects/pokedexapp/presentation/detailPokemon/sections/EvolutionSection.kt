package com.myprojects.pokedexapp.presentation.detailPokemon.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.entity.PokemonUi

@Composable
fun EvolutionSection(pokemonui: PokemonUi) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)) {
        titulo()
        evolution1(pokemonui = pokemonui)
    }
}

@Composable
fun titulo(){
    Text(
        text = "Evolution Chain",
        fontFamily = FontFamily(Font(R.font.circularstdblack)),
    )
}

@Composable
fun evolution1(pokemonui: PokemonUi){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 20.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Column {
            Image(painter = painterResource(id = pokemonui.pokemonDrawableResourceId), contentDescription = "imgPokemon", )
            Text(text = "${pokemonui.english_name}")
        }
        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "arrow", tint = Color.LightGray )
        Column {
            Image(painter = painterResource(id = pokemonui.pokemonDrawableResourceId), contentDescription = "imgEvolution", )
            Text(text = "${pokemonui.evochain_2}")
        }
    }
}