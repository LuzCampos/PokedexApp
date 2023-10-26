package com.myprojects.pokedex.presentation.onboarding

import androidx.annotation.DrawableRes
import com.agileapps.pokedex.R

data class QuestionSectionState(
    val question : String,
    val answers : List<String>,
    @DrawableRes val backgroundScreen : Int,
)

val pokemontyp = QuestionSectionState(
    question = "Which Pokemon type do you find most fascinating?",
    answers = listOf("Fire", "Water", "Grass", "Electric"),
    backgroundScreen = R.drawable.bg_water_2
)

val pokemonabilitie = QuestionSectionState(
    question = "What kind of Pokemon abilities do you prefer?",
    answers = listOf("Offensive (e.g., Fire Blast, Thunderbolt)",
            "Defensive (e.g., Protect, Recover)",
            "Balanced (a mix of offense and defense)",
            "Status Effect (e.g., Sleep Powder, Toxic)"),
    backgroundScreen = R.drawable.bg_nigth_2
)
val pokemonregion = QuestionSectionState(
    question = "Which Pokemon region intrigues you the most?",
    answers = listOf("Kanto","Johto","Hoenn","Sinnoh"),
    backgroundScreen = R.drawable.bg_sunset_beatiful
)

val pokemonrarity = QuestionSectionState(
    question = "What's your favorite Pokemon rarity level?",
    answers = listOf("Common (e.g., Pidgey, Rattata)",
            "Uncommon (e.g., Growlithe, Abra)",
            "Rare (e.g., Snorlax, Lapras)", "Legendary/Mythical (e.g., Mewtwo, Arceus)"),
    backgroundScreen = R.drawable.bg_daylight
)

val pokemongames = QuestionSectionState(
    question = "What aspect of Pokemon games excites you the most?",
    answers = listOf("Battling other trainers",
            "Exploring new regions and environments",
            "Collecting different Pokemon species",
            "Solving puzzles and challenges"),
    backgroundScreen = R.drawable.bg_water_3
)



