package com.agileapps.pokedex

import com.agileapps.pokedex.data.PokemonEntity

sealed class PokedexScreenState {
    object Loading : PokedexScreenState()
    data class Success(val pokemons: List<PokemonEntity>) : PokedexScreenState()
    data class Error(val message: String) : PokedexScreenState()
}