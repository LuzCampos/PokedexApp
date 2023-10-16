package com.myprojects.pokedexapp.presentation.onboarding

data class WelcomeScreenState(
    val title : String,
    val description : String,
    val text_button : String
)

val welcomeState = WelcomeScreenState(
    title = "PokeDexPro", description = "Dive into a universe filled with hundreds of captivating creatures.", text_button = "Get Started",)
