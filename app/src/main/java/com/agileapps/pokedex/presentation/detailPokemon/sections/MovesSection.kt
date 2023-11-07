package com.agileapps.pokedex.presentation.detailPokemon.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agileapps.pokedex.R
import com.agileapps.pokedex.presentation.entity.PokemonUi
import java.util.*

@Composable
fun MovesSection(pokemonui: PokemonUi) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .fillMaxSize()
        .padding(horizontal = 10.dp, vertical = 10.dp),
        //verticalArrangement = Arrangement.Center,
        // horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { Title(stringResource(id = R.string.msg_moves_abilities)) }
        item { AbilitiesRow(pokemonui = pokemonui) }
        item {
            Box(modifier = Modifier.height(10.dp))
            if (pokemonui.abilities_hidden.isNotBlank() || pokemonui.abilities_hidden.isNotBlank())
                Title(title = stringResource(id = R.string.msg_moves_title_hidden_abilities))
            AbilitiesHidden(pokemonui = pokemonui)
        }
    }
}

@Composable
fun Title(title:String){
    Text(
        text = title,
        fontWeight = FontWeight.ExtraBold,
        //fontFamily = FontFamily(Font(R.font.circularstdblack)),
    )
}

@Composable
fun AbilitiesRow(pokemonui: PokemonUi){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = pokemonui.abilities_0, color = Color(0xFF8C9092))
        Box(
            modifier = Modifier
                .size(46.dp)
                .padding(6.dp)
                .background(color = Color.White, shape = CircleShape)
                .border(2.dp, Color(pokemonui.backgroundColorValue), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = pokemonui.pokemonTypeResourceId),
                modifier = Modifier.size(20.dp),
                tint = Color(pokemonui.backgroundColorValue), contentDescription = "iconType"
            )
        }
    }
}

@Composable
fun AbilitiesHidden(pokemonui: PokemonUi){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(pokemonui.abilities_hidden.isNotBlank())  Abilitie(pokemonui = pokemonui, pokemonui.abilities_hidden)
        if(pokemonui.abilities_1.isNotBlank())   Abilitie(pokemonui = pokemonui, abilitie = pokemonui.abilities_1)
    }
}

@Composable
fun Abilitie(pokemonui: PokemonUi, abilitie:String){
    Text(text = abilitie.uppercase(Locale.ROOT), color = Color.White,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 12.sp,
        modifier = Modifier
            .drawBehind {
                drawRoundRect(
                    color = Color(pokemonui.backgroundColorValue),
                    topLeft = Offset(0f, 0f),
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(10.dp.toPx(), 8.dp.toPx())
                ) }.padding(8.dp) )
}