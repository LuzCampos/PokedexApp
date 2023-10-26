package com.myprojects.pokedex.presentation.home.type

import androidx.compose.ui.graphics.Color
import com.agileapps.pokedex.R


class Type(
    val icon: Int,
    val label:Int,
    val type:String,
    val color:Color
)

val types = listOf(
    Type(icon = R.drawable.grass, label = R.string.msg_grass , type = "grass", color = Color(0xff48D0B0)),
    Type(icon = R.drawable.fire, label = R.string.msg_fire , type = "fire", color = Color(0xFFFB6C6C)),
    Type(icon = R.drawable.water, label = R.string.msg_water, type = "water", color = Color(0xFF77BDFE)),
    Type(icon = R.drawable.electric, label = R.string.msg_electric , type = "electric", color = Color(0xFFFFCE4B)),
    Type(icon = R.drawable.poison, label = R.string.msg_poison , type = "poison", color = Color(0xFF7C538C)),
    Type(icon = R.drawable.rock, label = R.string.msg_rock , type = "rock", color = Color(0xFFB1736C)),
    Type(icon = R.drawable.ice, label = R.string.msg_ice , type = "ice", color = Color(0xff00c6e0)),
    Type(icon = R.drawable.fairy, label = R.string.msg_fairy , type = "fairy", color = Color(0xfff06292)),
    Type(icon = R.drawable.dark, label = R.string.msg_dark , type = "dark", color = Color(0xff212121)),
    Type(icon = R.drawable.dragon, label = R.string.msg_dragon , type = "dragon", color = Color(0xff9c27b0)),
    Type(icon = R.drawable.fighting, label = R.string.msg_fighting , type = "fighting", color = Color(0xff550000)),
    Type(icon = R.drawable.flying, label = R.string.msg_flying , type = "flying", color = Color(0xffaf52bf)),
    Type(icon = R.drawable.ghost, label = R.string.msg_ghost , type = "ghost", color = Color(0xff482880)),
    Type(icon = R.drawable.normal, label = R.string.msg_normal , type = "normal", color = Color(0xff8d6e63)),
    Type(icon = R.drawable.psychic, label = R.string.msg_psychic , type = "psychic", color = Color(0xffec407a)),
    Type(icon = R.drawable.steel, label = R.string.msg_steel , type = "steel", color = Color(0xff9e9e9e)),
    Type(icon = R.drawable.ground, label = R.string.msg_ground , type = "ground", color = Color(0xffffa733)),
    Type(icon = R.drawable.bug, label = R.string.msg_bug , type = "bug", color = Color(0xffA6B91A))
)