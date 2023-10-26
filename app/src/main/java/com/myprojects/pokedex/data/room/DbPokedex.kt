package com.myprojects.pokedex.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myprojects.pokedex.data.PokemonEntity

@Database(
    entities = [PokemonEntity::class],
    version = 1,
    exportSchema = false
)

abstract class DbPokedex: RoomDatabase() {
    abstract fun pokedexDao(): PokedexDao

    companion object {
        @Volatile
        private var INSTANCE: DbPokedex? = null

        fun getDatabase(context: Context): DbPokedex {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    DbPokedex::class.java, "pokedex").createFromAsset("database/pokedex.db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}