package com.myprojects.pokedexapp.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.common.TitleHeader
import com.myprojects.pokedexapp.presentation.home.type.Type
import com.myprojects.pokedexapp.presentation.home.type.types

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(navController: NavController) {
    val pagerState = rememberPagerState()
    val pageCount = 4

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 26.dp)
            .padding(top = 140.dp)
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            HorizontalPager(
                pageCount = pageCount,
                state = pagerState,
                verticalAlignment = Alignment.Top
            ) { page ->
                when (page) {
                    0 -> WhatTypeOfPokemonMaster(types = types)
                    1 -> CaptureYourFirstPokemon()
                    2 -> CaptureThemAll()
                    3 -> WhatTypeOfPokemonMaster(types = types)
                }
            }
            //Indicator
            Row(
                Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(10.dp)
                    )
                }
            }
            ContinueButton(pagerState = pagerState)
        }

    }

}

@Composable
fun WhatTypeOfPokemonMaster(types: List<Type>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        TitleHeader(
            text = stringResource(id = R.string.title_onboardingscreen),
            modifier = Modifier
        )
        HorizontalCardsType(types = types)
    }
}

@Composable
fun HorizontalCardsType(types: List<Type>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(vertical = 40.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(types) { type ->
            Card(
                modifier = Modifier.size(120.dp),
                backgroundColor = type.color,
            ) {

            }
        }
    }
}

@Composable
fun CaptureYourFirstPokemon() {
    Column(modifier = Modifier.height(400.dp)) {
        TitleHeader(text = "Capture Your First Pokemon", modifier = Modifier)
    }
}

@Composable
fun CaptureThemAll() {
    Column(modifier = Modifier.height(400.dp)) {
        TitleHeader(text = "Captúralos", modifier = Modifier)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContinueButton(pagerState: PagerState) {
    AnimatedVisibility(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 100.dp),
        visible = pagerState.currentPage == 2
    ) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color(0xff6C79DB)
            )
        ) {
            Text(text = "Continuar")
        }
    }
}