package com.agileapps.pokedex.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.agileapps.pokedex.data.PokemonEntity
import com.agileapps.pokedex.repository.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val pokedexRepository: PokedexRepository) : ViewModel() {
    val pokemon : LiveData<PokemonEntity> = pokedexRepository.getpokemon
    val pokemonEvo0 : LiveData<PokemonEntity> = pokedexRepository.getEvo0
    val pokemonEvo2 : LiveData<PokemonEntity> = pokedexRepository.getEvo2
    val pokemonEvo4 : LiveData<PokemonEntity> = pokedexRepository.getEvo4

    fun getPokemonById(pokemonId: Int) { pokedexRepository.getPokemon(pokemonId) }

    fun getPokemonByName(pokemonName:String){ pokedexRepository.getPokemonByName(pokemonName) }

    fun getPokemonEvo0ByName(pokemonName:String){ pokedexRepository.getEvo0ByName(pokemonName) }

    fun getPokemonEvo2ByName(pokemonName:String){ pokedexRepository.getEvo2ByName(pokemonName) }

    fun getPokemonEvo4ByName(pokemonName:String){ pokedexRepository.getEvo4ByName(pokemonName) }
}