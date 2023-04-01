package com.myprojects.pokedexapp.repository

import androidx.lifecycle.MutableLiveData
import com.myprojects.pokedexapp.PokedexScreenState
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.data.room.PokedexDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokedexRepository (private val pokedexDao: PokedexDao) {
    val pokemones = MutableLiveData<List<PokemonEntity>>()
    val getpokemon = MutableLiveData<PokemonEntity>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun getAllPokemons(){
        coroutineScope.launch {
            pokemones.postValue(pokedexDao.obtenerPokemons())
        }
    }

   /* suspend fun getAllPokemons(): PokedexScreenState {
        //coroutineScope.launch {
            return try {
                val items = pokedexDao.obtenerPokemons()
                if (items.isNotEmpty()) {
                    PokedexScreenState.Success(items)
                } else {
                    PokedexScreenState.Loading
                }
            } catch (e: Exception) {
                PokedexScreenState.Error("Failed to fetch items: ${e.message}")
            }
           // pokemones.postValue(pokedexDao.obtenerPokemons())
        //}
    }*/

    fun getPokemon(pokemonId: Int){
        coroutineScope.launch(Dispatchers.IO) {
            getpokemon.postValue(pokedexDao.getPokemonById(pokemonId))
        }
    }

    fun searchPokemonByName(searchText: String) {
        coroutineScope.launch(Dispatchers.IO) {
            pokemones.postValue(pokedexDao.searchPokemonsByName("%$searchText%"))
        }
    }

    fun getPokemonByGeneration(generation: String) {
        coroutineScope.launch(Dispatchers.IO) {
            pokemones.postValue(pokedexDao.getPokemonByGeneration(generation))
        }
    }
}

