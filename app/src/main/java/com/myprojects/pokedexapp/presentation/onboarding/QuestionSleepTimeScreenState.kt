package com.myprojects.pokedexapp.presentation.onboarding

import androidx.annotation.ColorLong
import androidx.annotation.DrawableRes
import com.myprojects.pokedexapp.R

data class QuestionSleepTimeScreenState(
    val title: String,
    val answers: List<String>,
    @DrawableRes val backgroundResourceId: Int,
    @ColorLong val color: Long
)

val newState = QuestionSleepTimeScreenState(
    title = "¿Cuánto duermes\nhábitualmente por la noche?",
    answers = listOf(
        "7 horas o menos",
        "7-9 horas",
        "9-12 horas",
        "12 horas o más"
    ),
    backgroundResourceId = R.drawable.bg_winter,
    color = 0xff6160ec
)