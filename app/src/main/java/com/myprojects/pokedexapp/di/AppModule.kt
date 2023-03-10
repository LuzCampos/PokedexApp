package com.myprojects.pokedexapp.di

import com.myprojects.pokedexapp.data.room.PokedexDao
import com.myprojects.pokedexapp.repository.PokedexRepository
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