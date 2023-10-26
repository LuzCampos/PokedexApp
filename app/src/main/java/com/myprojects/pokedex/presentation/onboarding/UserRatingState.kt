package com.myprojects.pokedex.presentation.onboarding

import androidx.annotation.ColorLong
import androidx.annotation.DrawableRes
import com.agileapps.pokedex.R

data class UserRatingState(
    val name:String,
    @ColorLong val backgroundColor: Long,
    @DrawableRes val backgroundResourceId: Int,
    val type:String,
    val punctuation:Double,
    val titleimg:String,
    val winrate :Int,
    val navigateTo: (String) -> Unit
)

val flamegoldgnome = UserRatingState(
    name = "Mystic\nMaster", backgroundColor = 0xff0079FF, backgroundResourceId = R.drawable.mystic,
    type = "You are drawn to the mystical side of Pokémon. Legends, ancient runes, and psychic abilities fascinate you.",
    punctuation = 9.8, titleimg = "Afinity rate", winrate = 92,
    navigateTo = {
    } )
