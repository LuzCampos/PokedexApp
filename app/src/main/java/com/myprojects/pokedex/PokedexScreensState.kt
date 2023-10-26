package com.myprojects.pokedex

import com.myprojects.pokedex.data.PokemonEntity

sealed class PokedexScreenState {
    object Loading : PokedexScreenState()
    data class Success(val pokemons: List<PokemonEntity>) : PokedexScreenState()
    data class Error(val message: String) : PokedexScreenState()
}