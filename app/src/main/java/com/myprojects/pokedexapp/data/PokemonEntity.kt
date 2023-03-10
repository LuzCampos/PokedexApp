package com.myprojects.pokedexapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokedex")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "national_number") val national_number:Int,
    @ColumnInfo(name = "gen") val gen:String,
    @ColumnInfo(name = "english_name") val english_name:String,
    @ColumnInfo(name = "japanese_name") val japanese_name:String,
    @ColumnInfo(name = "primary_type") val primary_type:String,
    @ColumnInfo(name = "secondary_type") val secondary_type:String,
    @ColumnInfo(name = "classification") val classification:String,
    @ColumnInfo(name = "percent_male") val percent_male:Double,
    @ColumnInfo(name = "percent_female") val percent_female:Double,
    @ColumnInfo(name = "height_m") val height_m:Double,
    @ColumnInfo(name = "weight_kg") val weight_kg:Double,
    @ColumnInfo(name = "capture_rate") val capture_rate:String,
    @ColumnInfo(name = "base_egg_steps") val base_egg_steps:String,
    @ColumnInfo(name = "hp") val hp:Int,
    @ColumnInfo(name = "attack") val attack:Int,
    @ColumnInfo(name = "defense") val defense:Int,
    @ColumnInfo(name = "sp_attack") val sp_attack:Int,
    @ColumnInfo(name = "sp_defense") val sp_defense:Int,
    @ColumnInfo(name = "speed") val speed:Int,
    @ColumnInfo(name = "abilities_0") val abilities_0:String,
    @ColumnInfo(name = "abilities_1") val abilities_1:String,
    @ColumnInfo(name = "abilities_2") val abilities_2:String,
    @ColumnInfo(name = "abilities_hidden") val abilities_hidden:String,
    @ColumnInfo(name = "against_normal") val against_normal:String,
    @ColumnInfo(name = "against_fire") val against_fire:String,
    @ColumnInfo(name = "against_water") val against_water:String,
    @ColumnInfo(name = "against_electric") val against_electric:String,
    @ColumnInfo(name = "against_grass") val against_grass:String,
    @ColumnInfo(name = "against_ice") val against_ice:String,
    @ColumnInfo(name = "against_fighting") val against_fighting:String,
    @ColumnInfo(name = "against_poison") val against_poison:String,
    @ColumnInfo(name = "against_ground") val against_ground:String,
    @ColumnInfo(name = "against_flying") val against_flying:String,
    @ColumnInfo(name = "against_psychic") val against_psychic:String,
    @ColumnInfo(name = "against_bug") val against_bug:String,
    @ColumnInfo(name = "against_rock") val against_rock:String,
    @ColumnInfo(name = "against_ghost") val against_ghost:String,
    @ColumnInfo(name = "against_dragon") val against_dragon:String,
    @ColumnInfo(name = "against_dark") val against_dark:String,
    @ColumnInfo(name = "against_steel") val against_steel:String,
    @ColumnInfo(name = "against_fairy") val against_fairy:String,
    @ColumnInfo(name = "is_sublegendary") val is_sublegendary:String,
    @ColumnInfo(name = "is_legendary") val is_legendary:String,
    @ColumnInfo(name = "is_mythical") val is_mythical:String,
    @ColumnInfo(name = "evochain_0") val evochain_0:String,
    @ColumnInfo(name = "evochain_1") val evochain_1:String,
    @ColumnInfo(name = "evochain_2") val evochain_2:String,
    @ColumnInfo(name = "evochain_3") val evochain_3:String,
    @ColumnInfo(name = "evochain_4") val evochain_4:String,
    @ColumnInfo(name = "evochain_5") val evochain_5:String,
    @ColumnInfo(name = "evochain_6") val evochain_6:String,
    @ColumnInfo(name = "gigantamax") val gigantamax:String,
    @ColumnInfo(name = "mega_evolution") val mega_evolution:String,
    @ColumnInfo(name = "mega_evolution_alt") val mega_evolution_alt:String,
    @ColumnInfo(name = "description") val description:String,

)