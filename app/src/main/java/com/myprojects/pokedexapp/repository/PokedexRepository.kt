package com.myprojects.pokedexapp.repository

import androidx.lifecycle.MutableLiveData
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.data.room.PokedexDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokedexRepository (private val pokedexDao: PokedexDao) {
    val pokemones = MutableLiveData<List<PokemonEntity>>()
    val getpokemon = MutableLiveData<PokemonEntity>()
    val getEvo0 = MutableLiveData<PokemonEntity>()
    val getEvo2 = MutableLiveData<PokemonEntity>()
    val getEvo4 = MutableLiveData<PokemonEntity>()
    val getpokemonid = MutableLiveData<Int>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun getAllPokemons(){
        coroutineScope.launch(Dispatchers.IO) {pokemones.postValue(pokedexDao.obtenerPokemons())}
    }

    fun getPokemon(pokemonId: Int){
      coroutineScope.launch(Dispatchers.IO) { getpokemon.postValue(pokedexDao.getPokemonById(pokemonId))}
    }

    fun searchPokemonByName(searchText: String) {
      coroutineScope.launch(Dispatchers.IO) { pokemones.postValue(pokedexDao.searchPokemonsByName("%$searchText%")) }
    }

    fun getPokemonByName(pokemonName: String){
        coroutineScope.launch(Dispatchers.IO) { getpokemon.postValue(pokedexDao.getPokemonByName(pokemonName))}
    }

    fun getEvo0ByName(pokemonName: String){
        coroutineScope.launch(Dispatchers.IO) { getEvo0.postValue(pokedexDao.getPokemonByName(pokemonName))}
    }

    fun getEvo2ByName(pokemonName: String){
        coroutineScope.launch(Dispatchers.IO) { getEvo2.postValue(pokedexDao.getPokemonByName(pokemonName))}
    }

    fun getEvo4ByName(pokemonName: String){
        coroutineScope.launch(Dispatchers.IO) { getEvo4.postValue(pokedexDao.getPokemonByName(pokemonName))}
    }

    fun getPokemonIdByName(pokemonName: String){
        coroutineScope.launch(Dispatchers.IO) { getpokemonid.postValue(pokedexDao.getPokemonNumberByName(pokemonName))}
    }

    fun getPokemonByGeneration(generation: String) {
      coroutineScope.launch(Dispatchers.IO) {
          pokemones.postValue(pokedexDao.getPokemonByGeneration(generation))
        }
    }

    fun getPokemonByType(type: String) {
        coroutineScope.launch(Dispatchers.IO) {
            pokemones.postValue(pokedexDao.getPokemonByType(type))
        }
    }
}

