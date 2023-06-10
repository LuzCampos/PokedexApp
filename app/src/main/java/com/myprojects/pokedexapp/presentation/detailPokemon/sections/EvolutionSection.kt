package com.myprojects.pokedexapp.presentation.detailPokemon.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.entity.PokemonUi

@Composable
fun EvolutionSection(pokemonui: PokemonUi,evochain_0_ui: PokemonUi? = null ,evochain_2_ui: PokemonUi? = null, evochain_4_ui : PokemonUi? = null) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)) {
        Titulo()
        if (evochain_2_ui != null) {
            if (pokemonui.english_name != evochain_2_ui.english_name) {
                EvolutionRow(pokemonui = pokemonui,
                    pokemonuiAdd = evochain_2_ui)
            }
        }
        if (evochain_4_ui != null ) {
            if (evochain_2_ui != null) {
                EvolutionRow(pokemonui = evochain_2_ui, pokemonuiAdd = evochain_4_ui )
            }
        } else if (evochain_0_ui != null && evochain_2_ui != null) {
            if(evochain_0_ui.english_name != pokemonui.english_name){
                EvolutionRow(pokemonui = evochain_0_ui, pokemonuiAdd = evochain_2_ui )
            }
        }
    }
}

@Composable
fun Titulo(){
    Text(
        modifier = Modifier.padding(vertical = 10.dp),
        text = "Evolution Chain",
        color = Color(0xff303943),
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.circularstdbold)),
    )
}


@Composable
fun EvolutionRow(pokemonui: PokemonUi, pokemonuiAdd:PokemonUi){

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(vertical = 20.dp), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
        Evolution(idImg = pokemonui.pokemonDrawableResourceId, pokemonui.english_name)
        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "arrow", tint = Color.LightGray )
        pokemonuiAdd?.let {
            Evolution(idImg = pokemonuiAdd.pokemonDrawableResourceId, pokemonuiAdd.english_name )
        }
    }
}

@Composable
fun Evolution(idImg:Int, evochain : String){
    Column( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .weight(2f),
            painter = painterResource(idImg), contentDescription = "imgPkmn" )
        Text(
            modifier = Modifier
                .weight(1f) ,
            text = evochain,
            color = Color(0xff303943),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.circularstdbook))
        )
    }
}
