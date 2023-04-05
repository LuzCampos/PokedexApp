package com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet

import androidx.compose.ui.graphics.Color
import com.myprojects.pokedexapp.R


class Type(
    val icon: Int,
    val label:String,
    val type:String,
    val color:Color
)

val types = listOf(
    Type(icon = R.drawable.grass, label = "Grass" , type = "grass", color = Color(0xff48D0B0)),
    Type(icon = R.drawable.fire, label = "Fire" , type = "fire", color = Color(0xFFFB6C6C)),
    Type(icon = R.drawable.water, label = "Water" , type = "water", color = Color(0xFF77BDFE)),
    Type(icon = R.drawable.electric, label = "Electric" , type = "electric", color = Color(0xFFFFCE4B)),
    Type(icon = R.drawable.poison, label = "Poison" , type = "poison", color = Color(0xFF7C538C)),
    Type(icon = R.drawable.rock, label = "Rock" , type = "rock", color = Color(0xFFB1736C)),
    Type(icon = R.drawable.ice, label = "Ice" , type = "ice", color = Color(0xff00c6e0)),
    Type(icon = R.drawable.fairy, label = "Fairy" , type = "fairy", color = Color(0xfff06292)),
    Type(icon = R.drawable.dark, label = "Dark" , type = "dark", color = Color(0xff212121)),
    Type(icon = R.drawable.dragon, label = "Dragon" , type = "dragon", color = Color(0xff9c27b0)),
    Type(icon = R.drawable.fighting, label = "Fighting" , type = "fighting", color = Color(0xff550000)),
    Type(icon = R.drawable.flying, label = "Flying" , type = "flying", color = Color(0xffaf52bf)),
    Type(icon = R.drawable.ghost, label = "Ghost" , type = "ghost", color = Color(0xff482880)),
    Type(icon = R.drawable.normal, label = "Normal" , type = "normal", color = Color(0xff8d6e63)),
    Type(icon = R.drawable.psychic, label = "Fairy" , type = "psychic", color = Color(0xffec407a)),
    Type(icon = R.drawable.steel, label = "Steel" , type = "steel", color = Color(0xff9e9e9e)),
    Type(icon = R.drawable.ground, label = "ground" , type = "ground", color = Color(0xffffa733))
)