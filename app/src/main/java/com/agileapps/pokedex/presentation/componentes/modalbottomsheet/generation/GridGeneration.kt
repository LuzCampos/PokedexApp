package com.agileapps.pokedex.presentation.componentes.modalbottomsheet.generation

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agileapps.pokedex.R
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.agileapps.pokedex.presentation.viewmodels.HomeViewModel

@Composable
fun GridGeneration(generation: List<Generation>, homeViewModel: HomeViewModel, closeSheet : () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
            //.height(574.dp)
            .background(MaterialTheme.colors.primaryVariant)
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(),
            columns = GridCells.Adaptive(144.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            header {
                Text(
                    text = stringResource(id = R.string.msg_generation_title),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.circularstdblack)),
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight =
                        FontWeight.ExtraBold
                    ),
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
            items(generation.size){
                    index ->
                val gen = generation[index]
                CardGeneration(generation = gen, homeViewModel = homeViewModel,closeSheet = closeSheet)
            }
        }
    }
}

@Composable
private fun CardGeneration(generation: Generation,homeViewModel: HomeViewModel,closeSheet : () -> Unit){
    Card(
        modifier = Modifier
            .height(116.dp)
            .clickable {
                homeViewModel.getPokemonByGeneration(generation.number)
                closeSheet()
            },
        shape = RoundedCornerShape(20.dp),
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = 6.dp
    ){
        Box( modifier = Modifier.padding(start = 16.dp, end = 4.dp)
        ) {
            Column(modifier = Modifier
                .align(Alignment.Center)
            ) {
                Text(text = stringResource(id = generation.label),
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.circularstdbook)),
                    fontSize = 14.sp, modifier = Modifier.padding(vertical = 5.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    ImageBitmap.imageResource(id = generation.icon), contentDescription = "",
                    modifier = Modifier.size(100.dp)  )
            }
        }
    }
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}