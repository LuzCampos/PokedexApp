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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.agileapps.pokedex.R
import com.agileapps.pokedex.presentation.componentes.modalbottomsheet.generation.header
import com.agileapps.pokedex.presentation.home.type.Type
import com.agileapps.pokedex.presentation.viewmodels.HomeViewModel

@Composable
fun GridType(types: List<Type>, homeViewModel: HomeViewModel,OnCloseSheet : () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
            .background(MaterialTheme.colors.primaryVariant)
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
                    text = stringResource(id = R.string.msg_fabItem_types),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.circularstdbold)),
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
                CardType(type = type, homeViewModel = homeViewModel,OnCloseSheet = OnCloseSheet)
            }
        }
    }
}

@Composable
private fun CardType(type: Type,homeViewModel: HomeViewModel,OnCloseSheet : () -> Unit){
    Card(
        modifier = Modifier
            .height(120.dp)
            .clickable {
                homeViewModel.getPokemonByType(type.type)
                OnCloseSheet()
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
                    painter = painterResource(id =  type.icon),
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.primaryVariant),
                    contentDescription = "type.icon", modifier = Modifier.size(80.dp)  )
            }
        }
    }
}


