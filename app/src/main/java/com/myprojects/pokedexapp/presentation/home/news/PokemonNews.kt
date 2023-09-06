package com.myprojects.pokedexapp.presentation.home.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.pokedexapp.R

@Composable
fun PokemonNews() {
    Box() {
        ComposableNews(news = news)
    }
}

@Composable
fun ComposableNews(news: List<News>){
    LazyColumn(
        modifier = Modifier.padding(top = 40.dp)
    ){
        item {
            Titles()
        }

        items(news.size){ index ->
            Texto(new = news[index])
                Divider()

        }
    }
}

@Composable
fun Texto(new: News){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp)) {
        Column(modifier = Modifier.align(Alignment.CenterStart), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                modifier = Modifier.width(186.dp),
                fontFamily = FontFamily(Font(R.font.circularstdbold)),
                fontSize = 14.sp,
                color = Color(0xff303943),
                text = new.title)
            Text(
                fontFamily = FontFamily(Font(R.font.circularstdbook)),
                fontSize = 10.sp,
                text = new.date)
        }

        Image(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(16))
                .size(width = 110.dp, height = 60.dp),
            painter = painterResource(id = new.image),
            contentScale = ContentScale.Crop,
            contentDescription = "newsImage")
    }
}

@Composable
fun Titles() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = stringResource(id = R.string.news_title),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.circularstdblack)),
                lineHeight = 42.sp,
                color = Color(0xff303943),
                fontSize = 18.sp
            )
            )
        Text(text = stringResource(id = R.string.news_item_viewall),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.circularstdbold)),
                color = Color(0xff6C79DB),
                lineHeight = 42.sp,
                fontSize = 14.sp
            ))
    }
}
