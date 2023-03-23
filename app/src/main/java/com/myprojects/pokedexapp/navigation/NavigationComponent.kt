package com.myprojects.pokedexapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.myprojects.pokedexapp.presentation.detailPokemon.PokemonDetail
import com.myprojects.pokedexapp.presentation.home.HomeScreen
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel

@Composable
fun NavigationComponent(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel
) {
    NavHost(navController = navHostController, startDestination = "home") {
        // First route : Home
        composable("home") {
            HomeScreen(navController = navHostController, homeViewModel )
        }
        composable("detail/{national_number}"){
                backStackEntry ->
            PokemonDetail( national_number = backStackEntry.arguments?.getString("national_number") , homeViewModel = homeViewModel, navController = navHostController)
        }
    }
}