package com.myprojects.pokedexapp.presentation.entity.translator

import androidx.annotation.DrawableRes
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.presentation.entity.PokemonUi

class PokemonTranslator {
    fun domainToUi(pokemon: PokemonEntity): PokemonUi {
        return PokemonUi(
            national_number = pokemon.national_number,
            english_name = pokemon.english_name,
            primary_type = pokemon.primary_type,
            height_m = pokemon.height_m,
            weight_kg = pokemon.weight_kg,
            percent_male = pokemon.percent_male,
            percent_female = pokemon.percent_female,
            hp = pokemon.hp,
            attack = pokemon.attack,
            defense = pokemon.defense,
            sp_attack = pokemon.sp_attack,
            sp_defense = pokemon.sp_defense,
            speed = pokemon.speed,
            classification = pokemon.classification ,
            description = pokemon.description,
            secondary_type = pokemon.secondary_type,
            pokemonDrawableResourceId = obtainDrawableResourceIdFromPokemon(pokemon),
            backgroundColorValue = obtainBackgroundColorFromPokemon(pokemon),
            //listaTypes = listOf(pokemon.primary_type,pokemon.secondary_type)
        )
    }

    private fun obtainBackgroundColorFromPokemon(pokemon: PokemonEntity): Long {
        return when (pokemon.primary_type) {
            "grass" -> 0xFF48D0B0
            "fire" -> 0xFFFB6C6C
            "water" -> 0xFF77BDFE
            "electric" -> 0xFFFFCE4B
            "poison" -> 0xFF7C538C
            "rock" -> 0xFFB1736C
            "fairy" -> 0xfff06292
            "rock"-> 0xFFB1736C
            "poison"-> 0xFF7C538C
            "dragon" -> 0xff9c27b0
            "ghost"-> 0xff482880
            "steel"-> 0xff9e9e9e
            "normal" -> 0xff8d6e63
            "ground" -> 0xffffa733
            "psychic" -> 0xffec407a
            "ice" -> 0xff00c6e0
            "flying" -> 0xffaf52bf
            "fighting" -> 0xff550000
            "dark" -> 0xff212121
            else -> 0xFFFFCE4B
        }
    }
}

@DrawableRes
private fun
        obtainDrawableResourceIdFromPokemon(pokemon: PokemonEntity): Int {
    return when (pokemon.english_name) {
        "Bulbasaur" -> R.drawable.bulbasaur_3x
        "Ivysaur" -> R.drawable.ivysaur_3x
        "Venusaur" -> R.drawable.venusaur_3x
        "Charmander" -> R.drawable.charmander_3x
        "Charmeleon" -> R.drawable.charmeleon_3x
        "Charizard" -> R.drawable.charizard_3x
        "Squirtle" -> R.drawable.squirtle_3x
        "Wartortle" -> R.drawable.wartortle_3x
        "Blastoise" -> R.drawable.blastoise_3x
        "Pikachu" -> R.drawable.pikachu_3x
        else -> R.drawable.pokeball
    }
}