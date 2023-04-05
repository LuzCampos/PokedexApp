package com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet

import com.myprojects.pokedexapp.R

class Generation(
    val icon: Int,
    val label:String,
    val number:String,
)

val generations = listOf(
    Generation(icon = R.drawable.generation1, label = "Generation I","I"),
    Generation(icon = R.drawable.generation2, label = "Generation II","II"),
    Generation(icon = R.drawable.generation3, label = "Generation III","III"),
    Generation(icon = R.drawable.generation4, label = "Generation IV","IV"),
    Generation(icon = R.drawable.generation5, label = "Generation V","V"),
    Generation(icon = R.drawable.generation6, label = "Generation VI","VI"),
    Generation(icon = R.drawable.generation7, label = "Generation VII","VII"),
    Generation(icon = R.drawable.generation8, label = "Generation VIII","VIII"),
)

