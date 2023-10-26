package com.agileapps.pokedex.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.agileapps.pokedex.R
import com.agileapps.pokedex.presentation.common.PokeBallBackground
import com.agileapps.pokedex.presentation.common.SearchComponent
import com.agileapps.pokedex.presentation.common.TitleHeader
import com.agileapps.pokedex.presentation.home.news.PokemonNews
import com.agileapps.pokedex.presentation.home.type.TypeGrid
import com.agileapps.pokedex.presentation.home.type.types
import com.agileapps.pokedex.presentation.viewmodels.HomeViewModel

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {

    val searchText = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxWidth()
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 26.dp)
                .padding(top = 110.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            TitleHeader(
                text = stringResource(id = R.string.title_homescreen),
                //"What Pokemon\nare you looking for?",
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                Color(0xff303943)
            )
            SearchComponent(
                searchText = searchText,
                homeViewModel = homeViewModel,
                modifier = Modifier.padding(top = 20.dp)
            )
            TypeGrid(types = types, homeViewModel = homeViewModel, navController )
            PokemonNews()
        }
        PokeBallBackground()
    }
}


