package com.myprojects.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.myprojects.pokedexapp.navigation.NavigationComponent
import com.myprojects.pokedexapp.ui.theme.PokedexAppTheme
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexAppTheme {
                // A surface container using the 'background' color from the theme
                NavigationComponent(navHostController = rememberNavController(), homeViewModel = homeViewModel )
            }
        }
    }
}

