package com.myprojects.pokedexapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.repository.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pokedexRepository: PokedexRepository) : ViewModel() {

    val pokemonesLista : LiveData<List<PokemonEntity>> = pokedexRepository.pokemones
    val pokemon : LiveData<PokemonEntity> = pokedexRepository.getpokemon

    init {
        getPokemons()
    }

    fun getPokemons(){
        pokedexRepository.getAllPokemons()
    }

    fun getPokemonById(pokemonId: Int) {
        pokedexRepository.getPokemon(pokemonId)
    }
}