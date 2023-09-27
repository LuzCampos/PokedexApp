package com.myprojects.pokedexapp.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.myprojects.pokedexapp.presentation.home.type.types
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {
    val pagerState = rememberPagerState()
    val pageCount = 4

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 26.dp)
            .padding(top = 160.dp)
    ) {
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            item {
                HorizontalPager(
                    pageCount = pageCount,
                    state = pagerState,
                    verticalAlignment = Alignment.Top
                ) { page ->
                    when (page) {
                        0 -> WhatTypeOfPokemonMaster(types = types)
                        1 -> CaptureYourFirstPokemon()
                        2 -> CaptureThemAll()
                    }
                }
            }
            //Indicator
            item {
                Row(
                    Modifier
                        .height(50.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pageCount) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) Color(0xff6C79DB) else Color.LightGray
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(10.dp)
                        )
                    }
                }
            }
            item {
                ContinueButton(
                    pagerState = pagerState
                ) {
                    navController.navigate("home_screen")
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContinueButton(pagerState: PagerState, onClick : () -> Unit) {
    AnimatedVisibility(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 100.dp),
        visible = pagerState.currentPage == 2
    ) {
        Button(
            onClick = {
                onClick()
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color(0xff6C79DB)
            )
        ) {
            Text(text = "Continuar")
        }
    }
}