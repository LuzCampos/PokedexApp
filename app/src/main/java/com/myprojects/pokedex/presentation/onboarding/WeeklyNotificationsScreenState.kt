package com.myprojects.pokedex.presentation.onboarding

import androidx.annotation.ColorLong
import androidx.annotation.DrawableRes
import com.agileapps.pokedex.R

data class WeeklyNotificationsScreenState(
    @ColorLong val backgroundColorInside : Long,
    @ColorLong val backgroundColorOutside : Long,
    @DrawableRes val imageScreen : Int,
    @DrawableRes val topleftIcon : Int,
    val toprightText : String,
    @DrawableRes val bottomleftIcon : Int,
    val title : String,
    val content : String
)

val pokemonOdyssey = WeeklyNotificationsScreenState(
    backgroundColorInside =
    0xffffc400,
    //0xffFBFFDC,
    backgroundColorOutside = 0xffffb300,
    imageScreen = R.drawable.instinct, topleftIcon = R.drawable.pokeballiconapp, toprightText = "001",
    bottomleftIcon = R.drawable.pointer, title = "Pokemon Odyssey : Weekly Tales",
    content = "Every week, you'll receive three special push notifications, each packed with exciting and in-depth information about a specific Pokemon" ,
)

val mewsenigmaticbirth = WeeklyNotificationsScreenState(
    backgroundColorInside = 0xfffccbc7,
    backgroundColorOutside = 0xfffeb1ab,
    //backgroundColor = 0xffffcccc,
    imageScreen = R.drawable.meow151,
    topleftIcon = R.drawable.pokeballiconapp,
    toprightText = "151",
    bottomleftIcon = R.drawable.pointer,
    title = "Mew’s\nEnigmatic Birth",
    content = "In the ancient times, when the universe was still a canvas of cosmic wonders, Mew emerged from the primordial essence of life.\n" +
           // "A celestial being, Mew possessed the genetic blueprints of every known Pokémon, encapsulating the universe's evolutionary potential within its delicate form.\n" +
            "Mew wandered the cosmos, seeding life across worlds, and became the symbol of unexplored mysteries." ,
)