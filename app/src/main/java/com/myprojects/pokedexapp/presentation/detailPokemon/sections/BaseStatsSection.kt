package com.myprojects.pokedexapp.presentation.detailPokemon.sections

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.myprojects.pokedexapp.presentation.entity.PokemonUi

data class Stat(
    val label: String,
    val value: Int?,
    val max: Int = 100
) {
    val progress: Float =
        1f * (value ?: 0) / max
}

@Composable
fun BaseStatsSection(pokemonui: PokemonUi) {
    val stats = listOf(
        Stat("HP", pokemonui.hp),
        Stat("Attack", pokemonui.attack),
        Stat("Defense", pokemonui.defense),
        Stat("Sp. Atk", pokemonui.sp_attack),
        Stat("Sp. Def", pokemonui.sp_defense),
        Stat("Speed", pokemonui.speed),
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
            .fillMaxWidth()
            .padding(16.dp)) {
        // Here is the header
        // Here are all the lines of your table.
        items(stats) {
           // val (id, text) = it
            Row(Modifier.fillMaxWidth()) {
                TableCell1(
                    text = it.label, weight = column1Weight
                )
                TableCell1(
                    text = it.value.toString(),
                    weight = column2Weight
                )
                linearBase(progress = it.progress, weight = column3Weight)
            }
        }
    }
}

@Composable
fun RowScope.TableCell1(
    text: String,
    weight: Float,
) {
    Text(text = text,
        Modifier
            .weight(weight)
            .padding(8.dp))
}

@Composable
fun textBaseStats(text: String){
    Text(text = "$text")
}

@Composable
fun RowScope.linearBase(progress: Float,weight: Float){
   LinearProgressIndicator(
       modifier = Modifier.weight(weight).padding(top = 18.dp),
       progress = progress,
       color = Color.Red
   )
}