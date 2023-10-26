package com.myprojects.pokedex.di

import com.myprojects.pokedex.data.room.PokedexDao
import com.myprojects.pokedex.repository.PokedexRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providePokemonRepository(pokedexDao: PokedexDao): PokedexRepository {
        return PokedexRepository(pokedexDao)
    }
}