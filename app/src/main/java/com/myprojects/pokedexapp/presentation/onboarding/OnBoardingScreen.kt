package com.myprojects.pokedexapp.presentation.onboarding

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {
    val pagerState = rememberPagerState()
    val pageCount = 9

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(bottom = 30.dp)
        //.padding(top = 160.dp)s
    ) {
        HorizontalPager(
            pageCount = pageCount,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { page ->
            when (page) {
               // 0 -> UserRatingScreen(flamegoldgnome)
                    //WelcomeScreen(welcomestate)
                //1 -> WeeklyNotificationsScreen()
                //2 -> WeeklyNotificationsScreen(mewsenigmaticbirth)
                //3 -> QuestionSectionScreen(pokemontyp)
                //4 -> QuestionSectionScreen(pokemonabilitie)
                //5 -> QuestionSectionScreen(pokemonregion)
                //6 -> QuestionSectionScreen(pokemonrarity)
                //7 -> QuestionSectionScreen(pokemongames)
                //8 -> UserRatingScreen(flamegoldgnome)
            }
        }
    }
}
