package com.agileapps.pokedex.data.room

import androidx.room.Dao
import androidx.room.Query
import com.agileapps.pokedex.data.PokemonEntity

@Dao
interface PokedexDao {
    @Query("SELECT * FROM pokedex")
    fun obtenerPokemons() : List<PokemonEntity>

    @Query("SELECT * FROM pokedex WHERE national_number = :national_number")
    fun getPokemonById(national_number: Int): PokemonEntity

    @Query("SELECT national_number FROM pokedex WHERE english_name = :english_name")
    fun getPokemonNumberByName(english_name : String) : Int

    @Query("SELECT * FROM pokedex WHERE english_name = :english_name")
    fun getPokemonByName(english_name : String) : PokemonEntity

    @Query("SELECT * FROM pokedex WHERE gen =:gen")
    fun getPokemonByGeneration(gen: String): List<PokemonEntity>

    @Query("SELECT * FROM pokedex WHERE primary_type =:primary_type")
    fun getPokemonByType(primary_type: String): List<PokemonEntity>

    @Query("SELECT * FROM pokedex WHERE english_name LIKE :searchText")
    fun searchPokemonsByName(searchText: String): List<PokemonEntity>
}