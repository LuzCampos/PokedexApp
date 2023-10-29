package com.agileapps.pokedex.presentation.detailPokemon.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agileapps.pokedex.R
import com.agileapps.pokedex.presentation.entity.PokemonUi

@Composable
fun EvolutionSection(pokemonui: PokemonUi, evochain_0_ui: PokemonUi? = null, evochain_2_ui: PokemonUi? = null, evochain_4_ui : PokemonUi? = null) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)) {
        item { Titulo() }
        item {
            if (evochain_0_ui != null && evochain_2_ui != null ) {
                EvolutionRow(pokemonui = evochain_0_ui, pokemonuiAdd = evochain_2_ui )
            }
            if (evochain_2_ui != null && evochain_4_ui != null) {
                EvolutionRow(pokemonui = evochain_2_ui, pokemonuiAdd = evochain_4_ui )
            }
        }
    }
}
@Composable
fun Titulo(){
    Text(
        modifier = Modifier.padding(vertical = 10.dp),
        text = stringResource(id = R.string.msg_evolution_title),
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
        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "arrow", tint = Color(0xff303943),)
        pokemonuiAdd?.let {
            Evolution(idImg = pokemonuiAdd.pokemonDrawableResourceId, pokemonuiAdd.english_name )
        }
    }
}

@Composable
fun Evolution(idImg:Int, pokemonName : String){
    val isSystemInDarkTheme = isSystemInDarkTheme()

    val backgroundColor = if (isSystemInDarkTheme) {
        Color.White // Utiliza el color de fondo predeterminado del modo noche
    } else {
        Color(0xff303943) // Color de fondo en modo claro
    }

    Column( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.weight(4f), contentAlignment = Alignment.Center) {
            Image(
                modifier = Modifier.height(100.dp),
                painter = painterResource(id = R.drawable.pokeballbackground),
                contentDescription = "",
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onPrimary.copy(0.09f))
            )
            Image(
                modifier = Modifier.size(60.dp),
                painter = painterResource(idImg), contentDescription = pokemonName
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier
                .weight(1f) ,
            text = pokemonName,
            color = Color(0xff303943),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.circularstdbook))
        )
    }
}
