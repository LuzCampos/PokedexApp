package com.agileapps.pokedex.di

import com.agileapps.pokedex.data.room.PokedexDao
import com.agileapps.pokedex.repository.PokedexRepository
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