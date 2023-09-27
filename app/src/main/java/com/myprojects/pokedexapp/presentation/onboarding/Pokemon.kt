package com.myprojects.pokedexapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.myprojects.pokedexapp.R

class Pokemon(
    val pokemonName : String,
    @DrawableRes val drawableResourceId: Int,
)

val pokemones = listOf(
    Pokemon("Bulbasaur", R.drawable.bulbasaur_3x),
    Pokemon("Ivysaur", R.drawable.ivysaur_3x),
    Pokemon("Venusaur", R.drawable.venusaur_3x),
    Pokemon("Oddish", R.drawable.pokemon_043),
  //  Pokemon("Gloom", R.drawable.pokemon_044),
  //  Pokemon("Bellsprout", R.drawable.pokemon_069),
  //  Pokemon("Weepinbell", R.drawable.pokemon_070),
   // Pokemon("Victreebel", R.drawable.pokemon_071),
)