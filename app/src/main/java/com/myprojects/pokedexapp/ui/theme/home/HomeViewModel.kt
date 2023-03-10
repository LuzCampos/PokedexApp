package com.myprojects.pokedexapp.ui.theme.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.repository.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pokedexRepository: PokedexRepository) : ViewModel() {

    val pokemonesLista : LiveData<List<PokemonEntity>> = pokedexRepository.pokemones

    fun getPokemons(){
        pokedexRepository.getAllPokemons()
    }
}