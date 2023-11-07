package com.agileapps.pokedex.presentation.onboarding

import androidx.annotation.ColorLong
import androidx.annotation.DrawableRes
import com.agileapps.pokedex.R

data class WeeklyNotificationsScreenState(
    @ColorLong val backgroundColorInside : Long,
    @ColorLong val backgroundColorOutside : Long,
    @DrawableRes val imageScreen : Int,
    @DrawableRes val topLeftIcon : Int,
    val topRightText : Int,
    @DrawableRes val bottomLeftIcon : Int,
    val title : Int,
    val content : Int
)

val pokemonOdyssey = WeeklyNotificationsScreenState(
    backgroundColorInside = 0xffffc400,
    backgroundColorOutside = 0xffffb300,
    imageScreen = R.drawable.instinct, topLeftIcon = R.drawable.pokeballiconapp,
    topRightText = R.string.msg_toprighttext_pokemonodyssey,
    bottomLeftIcon = R.drawable.pointer, title = R.string.msg_title_pokemonodyssey,
    content = R.string.msg_content_pokemonodyssey
)

val mewsEnigmaticBirth = WeeklyNotificationsScreenState(
    backgroundColorInside = 0xfffccbc7,
    backgroundColorOutside = 0xfffeb1ab,
    imageScreen = R.drawable.meow151,
    topLeftIcon = R.drawable.pokeballiconapp,
    topRightText = R.string.msg_toprighttext_mewsEnigmaticBirth,
    bottomLeftIcon = R.drawable.pointer,
    title = R.string.msg_title_mewsEnigmaticBirth,
    content = R.string.msg_content_mewsEnigmaticBirth
)