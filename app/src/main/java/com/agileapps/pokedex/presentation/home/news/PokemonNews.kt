package com.agileapps.pokedex.presentation.home.news

import androidx.annotation.StringRes
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agileapps.pokedex.R

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
            CardNews(new = news[index])
                Divider()
        }
    }
}

@Composable
fun CardNews(new: News){
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
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextTitle(
                id = R.string.news_title,
                resId = R.font.circularstdblack,
                color = 0xff303943,
                fontSize = 18.sp)
        TextTitle(
                id = R.string.news_item_viewall,
                resId = R.font.circularstdbold,
                color = 0xff6C79DB,
                fontSize = 14.sp)
    }
}

@Composable
fun TextTitle(@StringRes id : Int, resId : Int, color : Long,fontSize : TextUnit){
    Text(text = stringResource(id = id),
        style = TextStyle(
            fontFamily = FontFamily(Font(resId)),
            lineHeight = 42.sp,
            color = Color(color),
            fontSize = fontSize
        )
    )
}
