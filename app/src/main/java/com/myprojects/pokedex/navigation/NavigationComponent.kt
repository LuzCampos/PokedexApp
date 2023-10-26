package com.myprojects.pokedex.navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.myprojects.pokedex.presentation.detailPokemon.PokemonDetail
import com.myprojects.pokedex.presentation.home.HomeScreen
import com.myprojects.pokedex.presentation.home.ListScreen
import com.myprojects.pokedex.presentation.onboarding.*
import com.myprojects.pokedex.presentation.viewmodels.DetailViewModel
import com.myprojects.pokedex.presentation.viewmodels.HomeViewModel

@Composable
fun NavigationComponent(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel,
    detailViewModel: DetailViewModel,
) {
    NavHost(
        navController = navHostController,
        startDestination = "list_pokedex_screen"
    ) {
        // First route : Home
        composable("onboarding_screen") {
            OnBoardingScreen(navController = navHostController, homeViewModel)
        }
        composable("welcome_screen") {
            WelcomeScreen(state = welcomeState, navigateTo = {
                navHostController.navigate("notification_screen")
            })
        }
        composable("notification_screen") {
            WeeklyNotificationsScreen(state = pokemonOdyssey){
                navHostController.navigate("notification_screen_two")
            }
        }
        composable("notification_screen_two") {
            WeeklyNotificationsScreen(state = mewsenigmaticbirth) {
                navHostController.navigate("user_rating_screen")
                //("question_screen_type")

            }
        }
        composable("question_screen_type") {
            QuestionSectionScreen(state = pokemontyp){
                navHostController.navigate("question_screen_abilitie")
            }
        }
        composable("question_screen_abilitie") {
            QuestionSectionScreen(state = pokemonabilitie){
                navHostController.navigate("question_screen_region")
            }
        }
        composable("question_screen_region") {
            QuestionSectionScreen(state = pokemonregion){
                navHostController.navigate("question_screen_rarity")
            }
        }
        composable("question_screen_rarity") {
            QuestionSectionScreen(state = pokemonrarity){
                navHostController.navigate("question_screen_games")
            }
        }
        composable("question_screen_games") {
            QuestionSectionScreen(pokemongames){
                navHostController.navigate("user_rating_screen")
            }
        }
        composable("user_rating_screen") {
            UserRatingScreen(flamegoldgnome) {
                navHostController.navigate("list_pokedex_screen")
            }
        }
        composable("home_screen") {
            HomeScreen(navController = navHostController, homeViewModel )
        }
        composable("crash_screen") {
            CrashScreen()
        }
        composable("list_pokedex_screen") {
            ListScreen(navController = navHostController, homeViewModel )
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
                detailViewModel,
                navController = navHostController)
        }
    }
}

@Composable
fun CrashScreen() {
    Button(onClick = { throw RuntimeException("Test Crash")  }) {
        Text(text = "BUG")
    }
}
