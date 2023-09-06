package com.myprojects.pokedexapp.presentation.detailPokemon.sections

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.entity.PokemonUi

data class Stat(
    @StringRes val label: Int,
    val value: Int?,
    val max: Int = 100
) {
    val progress: Float =
        1f * (value ?: 0) / max
}

@Composable
fun BaseStatsSection(pokemonui: PokemonUi) {
    val stats = listOf(
        Stat(R.string.msg_basestats_hp, pokemonui.hp),
        Stat(R.string.msg_basestats_attack, pokemonui.attack),
        Stat(R.string.msg_basestats_defense, pokemonui.defense),
        Stat(R.string.msg_basestats_spatk, pokemonui.sp_attack),
        Stat(R.string.msg_basestats_spdef, pokemonui.sp_defense),
        Stat(R.string.msg_basestats_speed, pokemonui.speed),
    )
    TableScreen(stats = stats)
}

@Composable
fun TableScreen(stats: List<Stat>) {
    val column1Weight = .3f // 30%
    val column2Weight = .2f // 10%
    val column3Weight = .6f // 60%
    // The LazyColumn will be our table. Notice the use of the weights below
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        // Here is the header
        // Here are all the lines of your table.
        items(stats) {
           // val (id, text) = it
            Row(Modifier.fillMaxWidth()) {
                TableCell1(
                    text = stringResource(id = it.label), weight = column1Weight, Color(0xff83888E)
                )
                TableCell1(
                    text = it.value.toString(),
                    weight = column2Weight,
                    Color(0xff303943)
                )
                LinearBase(progress = it.progress, weight = column3Weight)
            }
        }
    }
}

@Composable
fun RowScope.TableCell1(
    text: String,
    weight: Float,
    color: Color
) {
    Text(text = text,
        Modifier
            .weight(weight)
            .padding(8.dp),
        color = color
    )

}


@Composable
fun RowScope.LinearBase(progress: Float,weight: Float){

   val color = if(progress < 0.51f)
   {
       Color(0xffFB6C6C)
   } else {
       Color(0xff4BC07A)
   }

   LinearProgressIndicator(
       modifier = Modifier
           .weight(weight)
           .padding(top = 18.dp)
           .clip(RoundedCornerShape(10.dp)),
       progress = progress,
       color = color,
       backgroundColor = Color(0xffF5F6F5)
   )
}