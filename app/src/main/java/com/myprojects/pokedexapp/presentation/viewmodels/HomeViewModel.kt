package com.myprojects.pokedexapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myprojects.pokedexapp.PokedexScreenState
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.repository.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pokedexRepository: PokedexRepository) : ViewModel() {

    val pokemonesLista : LiveData<List<PokemonEntity>> = pokedexRepository.pokemones
    val pokemon : LiveData<PokemonEntity> = pokedexRepository.getpokemon

    private val _uiState = MutableLiveData<PokedexScreenState>()
    val uiState: LiveData<PokedexScreenState> = _uiState

    init { getPokemons() }

    fun getPokemons(){ pokedexRepository.getAllPokemons() }

    fun getPokemonById(pokemonId: Int) { pokedexRepository.getPokemon(pokemonId) }

    fun getPokemonByGeneration(generation: String) { pokedexRepository.getPokemonByGeneration(generation) }

    fun getPokemonByType(type: String) { pokedexRepository.getPokemonByType(type) }

    fun searchPokemonByName(searchText:String){
        viewModelScope.launch {
            pokedexRepository.searchPokemonByName(searchText)
        }
    }

}