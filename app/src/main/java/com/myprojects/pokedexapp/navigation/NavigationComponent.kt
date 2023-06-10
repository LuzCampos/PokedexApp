package com.myprojects.pokedexapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.myprojects.pokedexapp.presentation.detailPokemon.PokemonDetail
import com.myprojects.pokedexapp.presentation.home.HomeScreen
import com.myprojects.pokedexapp.presentation.viewmodels.DetailViewModel
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel

@Composable
fun NavigationComponent(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel,
    detailViewModel: DetailViewModel
) {
    NavHost(navController = navHostController, startDestination = "home") {
        // First route : Home
        composable("home") {
            HomeScreen(navController = navHostController, homeViewModel )
        }
        composable("detail?national_number={national_number}&evochain_0={evochain_0}&evochain_2={evochain_2}&evochain_4={evochain_4}",
            arguments = listOf(
                navArgument("national_number") {
                    type = NavType.StringType
                    nullable = false
                }, navArgument("evochain_0") {
                    type = NavType.StringType
                    nullable = true
                    //defaultValue = null
                }, navArgument("evochain_2") {
                    type = NavType.StringType
                    nullable = true
                    //defaultValue = null
                }, navArgument("evochain_4") {
                    type = NavType.StringType
                    nullable = true
                    //defaultValue = null
                }
            )){
                backStackEntry ->
            PokemonDetail( national_number = backStackEntry.arguments?.getString("national_number") ,
                evochain_0 = backStackEntry.arguments?.getString("evochain_0"),
                evochain_2 = backStackEntry.arguments?.getString("evochain_2"),
                evochain_4 = backStackEntry.arguments?.getString("evochain_4"),
                detailViewModel = detailViewModel, navController = navHostController)
        }
    }
}