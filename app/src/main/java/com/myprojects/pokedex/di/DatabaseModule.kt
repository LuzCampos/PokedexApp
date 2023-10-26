package com.myprojects.pokedex.di

import android.content.Context
import androidx.room.Room
import com.myprojects.pokedex.data.room.DbPokedex
import com.myprojects.pokedex.data.room.PokedexDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun providePokedexDao(appDatabase : DbPokedex): PokedexDao {
        return appDatabase.pokedexDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): DbPokedex {
        return Room.databaseBuilder(
            context.applicationContext,
            DbPokedex::class.java,
            "pokedex.db"
        ).createFromAsset("database/pokedex.db").build()
    }
}