package com.agileapps.pokedex.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.agileapps.pokedex.R

@Composable
fun BoxScope.PokeBallBackground(){
    Box(
        modifier = Modifier
            .align(Alignment.TopEnd)
            .offset(x = 90.dp, y = (-60).dp),
    ) {
        Image(
            modifier = Modifier.size(274.dp).align(Alignment.TopEnd),
            painter = painterResource(R.drawable.pokeballbackground),
            contentDescription = "Pokeball Shadow",
            colorFilter = ColorFilter.tint(color = Color(0xff303943).copy(0.06f))
        )
    }
}

@Composable
fun PokeballImageCard(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.pokedexcard),
        contentDescription = "Pokeball Shadow",
        modifier = modifier.size(width = 88.dp, height = 76.dp),
    )
}

@Composable
fun PokemonImage(
    @DrawableRes drawableResourceId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(drawableResourceId),
        contentDescription = "",
        modifier = modifier
            //.fillMaxWidth(.5f)
            .size(width = 72.dp, height = 72.dp)
    )
}

@Composable
fun PokeballImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.pokeball),
        contentDescription = null,
        modifier = modifier.size(width = 88.dp, height = 76.dp),
    )
}