package com.myprojects.pokedexapp.repository

import androidx.lifecycle.MutableLiveData
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.data.room.PokedexDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokedexRepository(private val pokedexDao: PokedexDao) {
    val pokemones = MutableLiveData<List<PokemonEntity>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun getAllPokemons(){
        coroutineScope.launch {
            pokemones.postValue(pokedexDao.obtenerPokemons())
        }
    }
}