package com.agileapps.pokedex.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomAppBar(onClick : () -> Unit, tint : Color) {
    Box {
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp, bottom = 16.dp),
            title = {

            },
            navigationIcon = {
                IconButton(
                    onClick = { onClick() }
                ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        tint = tint,
                        contentDescription = "ArrowBack"
                    )
                }
            }
        )
    }
}