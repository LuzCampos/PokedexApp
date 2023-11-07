package com.agileapps.pokedex.presentation.onboarding

import androidx.annotation.DrawableRes
import com.agileapps.pokedex.R

data class QuestionSectionState(
    val question : Int,
    val answers : List<Int>,
    @DrawableRes val backgroundScreen : Int,
)

val pokemonTypes = QuestionSectionState(
    question = R.string.msg_question_pokemonTyp,
    answers = listOf(R.string.msg_fire,R.string.msg_water, R.string.msg_grass, R.string.msg_electric),
    backgroundScreen = R.drawable.bg_water_2
)

val pokemonAbilities = QuestionSectionState(
    question = R.string.msg_question_pokemonAbilities,
    answers = listOf(R.string.msg_answerOne_pokemonAbilities,
            R.string.msg_answerTwo_pokemonAbilities,
            R.string.msg_answerThree_pokemonAbilities,
            R.string.msg_answerFour_pokemonAbilities),
    backgroundScreen = R.drawable.bg_nigth_2
)
val pokemonRegion = QuestionSectionState(
    question = R.string.msg_question_pokemonRegion,
    answers = listOf(R.string.msg_answerOne_pokemonRegion,
        R.string.msg_answerTwo_pokemonRegion,
        R.string.msg_answerThree_pokemonRegion,
        R.string.msg_answerFour_pokemonRegion),
    backgroundScreen = R.drawable.bg_sunset_beatiful
)

val pokemonRarity = QuestionSectionState(
    question = R.string.msg_question_pokemonRarity,
    answers = listOf(R.string.msg_answerOne_pokemonRarity,
            R.string.msg_answerTwo_pokemonRarity,
            R.string.msg_answerThree_pokemonRarity,
        R.string.msg_answerFour_pokemonRarity),
    backgroundScreen = R.drawable.bg_daylight
)

val pokemonGames = QuestionSectionState(
    question = R.string.msg_question_pokemonGames,
    answers = listOf(R.string.msg_answerOne_pokemonGames,R.string.msg_answerTwo_pokemonGames,
    R.string.msg_answerThree_pokemonGames,R.string.msg_answerFour_pokemonGames),
    backgroundScreen = R.drawable.bg_water_3
)



