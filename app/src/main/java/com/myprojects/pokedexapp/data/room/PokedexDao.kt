package com.myprojects.pokedexapp.data.room

import androidx.room.Dao
import androidx.room.Query
import com.myprojects.pokedexapp.data.PokemonEntity

@Dao
interface PokedexDao {
    @Query("SELECT * FROM pokedex")
    suspend fun obtenerPokemons() : List<PokemonEntity>

    @Query("SELECT * FROM pokedex WHERE national_number = :national_number")
    fun getPokemonById(national_number: Int): PokemonEntity
}