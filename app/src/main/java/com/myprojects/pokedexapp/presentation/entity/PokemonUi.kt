package com.myprojects.pokedexapp.presentation.entity

import androidx.annotation.DrawableRes

class PokemonUi (
    val national_number: Int,
    val english_name: String,
    val classification:String,
    val abilities_0:String,
    val abilities_1:String,
    val abilities_hidden:String,
    val description:String,
    val evochain_2:String,
    val height_m:Double,
    val weight_kg:Double,
    val percent_male:Double,
    val percent_female:Double,
    val hp:Int,
    val attack:Int,
    val defense:Int,
    val sp_attack:Int,
    val sp_defense:Int,
    val speed:Int,
    val primary_type:String,
    val secondary_type:String,
    @DrawableRes val pokemonDrawableResourceId: Int,
    @DrawableRes val pokemonTypeResourceId: Int,
    //@DrawableRes val pokemonDrawableEvolution: Int,
    val backgroundColorValue: Long,
) {
    fun getNumberFormatted(): String =
        "#${national_number.toString().padStart(length = 3, padChar = '0')}"

    fun getLibsFormatted(): String {
        var result: Double = weight_kg * 2.20462
        return "${result.toString().take(4)} lbs (${weight_kg.toString()} kg)"
    }

    fun getHeightFormatted(): String {
        var result: Double = (height_m*100) / 30.48
        return "${result.toString().take(4)}” (${height_m.toString().padEnd(4,padChar='0')} m)"
    }
}