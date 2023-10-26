package com.agileapps.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.agileapps.pokedex.navigation.NavigationComponent
import com.agileapps.pokedex.presentation.viewmodels.DetailViewModel
import com.agileapps.pokedex.presentation.viewmodels.HomeViewModel
import com.agileapps.pokedex.ui.theme.PokedexAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

   private val homeViewModel: HomeViewModel by viewModels()
   private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            PokedexAppTheme() {
                // A surface container using the 'background' color from the theme
                NavigationComponent(navHostController = rememberNavController(), homeViewModel,detailViewModel)
            }
        }
    }
}

