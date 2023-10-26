package com.agileapps.pokedex.presentation.componentes.modalbottomsheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.agileapps.pokedex.presentation.componentes.modalbottomsheet.generation.header
import com.agileapps.pokedex.presentation.home.type.Type
import com.agileapps.pokedex.presentation.viewmodels.HomeViewModel

@Composable
fun AllType(types: List<Type>, homeViewModel: HomeViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(440.dp)
            .background(Color.White)
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(),
            columns = GridCells.Adaptive(144.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            header {
                Text(
                    text = "Types",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight =
                        FontWeight.ExtraBold
                    ),
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
            items(types.size){
                    index ->
                val type = types[index]
                CardType(type = type, homeViewModel = homeViewModel)
            }
        }
    }
}

@Composable
private fun CardType(type: Type,homeViewModel: HomeViewModel){
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()

    Card(
        modifier = Modifier
            .height(120.dp)
            .clickable {
                homeViewModel.getPokemonByType(type.type)
            },
        shape = RoundedCornerShape(20.dp),
        backgroundColor = type.color,
        elevation = 10.dp
    ){
        Box( modifier = Modifier.padding(start = 16.dp, end = 4.dp)
        ) {
            Column(modifier = Modifier
                .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
               Image(
                   painter = rememberAsyncImagePainter(type.icon, imageLoader),
                   colorFilter = ColorFilter.tint(Color.White),
                   contentDescription = "", modifier = Modifier.size(80.dp)  )
            }
        }
    }
}

