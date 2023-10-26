package com.agileapps.pokedex.presentation.componentes.modalbottomsheet.generation

import com.agileapps.pokedex.R

class Generation(
    val icon: Int,
    val label:Int,
    val number:String,
)

val generations = listOf(
    Generation(icon = R.drawable.generation1, label = R.string.msg_generation_one,"I"),
    Generation(icon = R.drawable.generation2, label = R.string.msg_generation_two,"II"),
    Generation(icon = R.drawable.generation3, label = R.string.msg_generation_three,"III"),
    Generation(icon = R.drawable.generation4, label = R.string.msg_generation_four,"IV"),
    Generation(icon = R.drawable.generation5, label = R.string.msg_generation_five,"V"),
    Generation(icon = R.drawable.generation6, label = R.string.msg_generation_six,"VI"),
    Generation(icon = R.drawable.generation7, label = R.string.msg_generation_seven,"VII"),
    Generation(icon = R.drawable.generation8, label = R.string.msg_generation_eight,"VIII"),
)

