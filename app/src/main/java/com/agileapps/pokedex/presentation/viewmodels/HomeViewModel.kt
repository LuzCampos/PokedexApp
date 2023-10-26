package com.agileapps.pokedex.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agileapps.pokedex.PokedexScreenState
import com.agileapps.pokedex.data.PokemonEntity
import com.agileapps.pokedex.repository.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pokedexRepository: PokedexRepository) : ViewModel() {

    val pokemonesLista : LiveData<List<PokemonEntity>> = pokedexRepository.pokemones

    private val _uiState = MutableLiveData<PokedexScreenState>()
    val uiState: LiveData<PokedexScreenState> = _uiState

    init { getPokemons() }

    fun getPokemons(){ pokedexRepository.getAllPokemons() }

    fun getPokemonByGeneration(generation: String) { pokedexRepository.getPokemonByGeneration(generation) }

    fun getPokemonByType(type: String) {
        viewModelScope.launch {
            pokedexRepository.getPokemonByType(type)
        }
    }

    fun searchPokemonByName(searchText:String){
        viewModelScope.launch {
            pokedexRepository.searchPokemonByName(searchText)
        }
    }

}