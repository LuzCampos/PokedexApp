package com.myprojects.pokedexapp.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.common.TitleHeader

data class CardItem(val title: String, val description: String, val price: String, @DrawableRes val icon: Int )

val cardList = listOf(
    CardItem("Unlimited plan", "$124 billed Unlimited plan", "8", R.drawable.unlimited_pokeball_icon),
    CardItem("1 year plan", "224 billed every year", "12", R.drawable.oneyear_pokeball_icon),
    CardItem("Monthly plan", "", "19", R.drawable.monthly_pokeball_icon)
)

@Composable
fun QueMaestroEres(navController: NavController) {

    var defaultSelectedItemIndex by remember { mutableStateOf(-1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffF5F5F5))
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 30.dp),
            verticalArrangement = Arrangement.Top
        ) {

            TitleHeader(
                "Pricing Plan",
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 20.dp, top = 50.dp),
                Color(0xff303943)
            )
            SubTitleText(
                text = "Choose a subscription plan to unlock all the functionality of the application",
                modifier = Modifier
                    .padding(bottom = 60.dp, start = 2.dp, end = 4.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color(0xff303943),
                fontSize = 14.sp,
                TextAlign.Center
            )
            cardList.forEachIndexed { index, item ->
                val isSelected = index == defaultSelectedItemIndex
                val backgroundColor = if (isSelected) Color(0xff7f5df9) else Color(0xffFFFFFF)
                val textPriceColor = if (isSelected) Color.White else Color(0xff805cfa)
                val textCardContent = if (isSelected) Color.White else Color(0xff494949)
                //val borderCardColor = if (isSelected) Color.Transparent  else Color.LightGray

                CardItemContent(
                    backgroundColor = backgroundColor,
                    textCardContent,
                    textPriceColor,
                    item = item
                ) {
                    defaultSelectedItemIndex = index
                }
            }
            ButtonContinue(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 90.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        navController.navigate("home_screen")
                    },
                text = "Continue", backgroundColor = Color(0xff7f5df9),
            )
        }
    }
}

@Composable
fun CardItemContent(backgroundColor:Color, textCardContent:Color,textPriceColor:Color, item: CardItem, onClick : () -> Unit ){
    Card(
        shape = RoundedCornerShape(18.dp),
        backgroundColor = backgroundColor,
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .wrapContentHeight()
            .padding(bottom = 16.dp)
            .clip(RoundedCornerShape(18.dp))
            .clickable { onClick() },
      //  border = BorderStroke(1.dp, borderCardColor)
    ) { CardRowContent(item, textCardContent, textPriceColor) }
}

@Composable
fun CardRowContent(item:CardItem,textCardContent:Color,textPriceColor:Color){
    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 26.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(item.icon),modifier = Modifier.size(40.dp),contentDescription = "")
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start, modifier = Modifier.padding(start = 10.dp)) {
                SubTitleText(item.title, Modifier , textCardContent , 14.sp,TextAlign.Center )
                if (item.description == "") Box(modifier = Modifier.size(0.dp))
                else SubTitleText(item.description, Modifier,textCardContent ,12.sp,TextAlign.Center)
            }
        }
        SubTitleRowItem(price = item.price, textPriceColor = textPriceColor, txtContent = textCardContent,modifier = Modifier)
    }
}

@Composable
fun SubTitleText(text : String, modifier: Modifier, color: Color, fontSize: TextUnit, textAlign: TextAlign) {
    Text(modifier = modifier, text = text, textAlign = textAlign, color = color,
        fontSize = fontSize, fontFamily = FontFamily(Font(R.font.circularstdbook)))
}

@Composable
fun SubTitleRowItem(price:String, textPriceColor : Color, txtContent : Color, modifier: Modifier){
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
        SubTitleText("$",
            Modifier
                .align(Alignment.CenterVertically)
                .padding(bottom = 6.dp), textPriceColor, 12.sp,TextAlign.Center)
        Text(modifier = Modifier.align(Alignment.Bottom), text = price, color = textPriceColor,
         fontFamily = FontFamily(Font(R.font.circularstdblack)), fontSize = 24.sp)
        SubTitleText( "/mo",
            Modifier
                .align(Alignment.Bottom)
                .padding(bottom = 4.dp), txtContent, 12.sp,TextAlign.Center)
    }
}

@Composable
fun ButtonContinue(modifier: Modifier,text: String, backgroundColor: Color){
    Card(
        modifier = modifier, backgroundColor = backgroundColor, contentColor = Color.White,
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = text, fontFamily = FontFamily(Font(R.font.circularstdbold)))
            Icon(
                modifier = Modifier
                    .height(24.dp)
                    .align(Alignment.CenterEnd)
                    .padding(end = 16.dp),
                painter = painterResource(id = R.drawable.flecha_icon), contentDescription = "",
            )
        }
    }
}