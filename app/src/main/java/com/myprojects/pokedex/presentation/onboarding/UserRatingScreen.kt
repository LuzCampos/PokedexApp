package com.myprojects.pokedex.presentation.onboarding

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.agileapps.pokedex.R

@Composable
fun UserRatingScreen(state: UserRatingState, navigateTo : () -> Unit) {
    val name = state.name
    val backgroundColor = state.backgroundColor
    val backgroundResourceId = state.backgroundResourceId
    val type = state.type
    val titleimage = state.titleimg
    val punctuation = state.punctuation
    val winrate = state.winrate

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color(backgroundColor))
        .padding(vertical = 30.dp, horizontal = 34.dp).padding(bottom = 24.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        item {

            Column(modifier = Modifier, verticalArrangement = Arrangement.Top) {
                TextsScreen(name,type)
                ImgBox(modifier = Modifier.fillMaxWidth(),punctuation,backgroundResourceId)
                WinRate(modifier = Modifier.align(Alignment.CenterHorizontally), titleimage,winrate)
            }
        }
        item {

            ContinueButtonHome(text_button = "Let's go") {
                navigateTo()
            }
        }
        // AppBarCustom()
      //  CustomBottomBar(modifier = Modifier)
    }
}

@Composable
fun WinRate(modifier: Modifier, titleimage:String,winrate : Int) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = titleimage, fontSize = 16.sp,fontFamily = FontFamily(Font(R.font.circularstdbook)),color = Color.Black)
        Text(text = "$winrate%", fontSize = 46.sp,fontFamily = FontFamily(Font(R.font.circularstdblack)),color = Color.Black)
    }
}

@Composable
fun ImgBox(modifier: Modifier, punctuation : Double, backgroundResourceId : Int) {
    Box(modifier = modifier.height(IntrinsicSize.Min)) {
        Column(modifier = Modifier
            .align(Alignment.TopStart)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(40.dp))
            .background(Color.White)) {
            Column(
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 10.dp)
                    .padding(top = 2.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(modifier = Modifier
                    .size(12.dp)
                    .wrapContentSize(unbounded = true),imageVector = Icons.Filled.Star, contentDescription = "", tint = Color.Black)
                Text(
                    modifier = Modifier.wrapContentSize(unbounded = true),
                    text = punctuation.toString(),
                    fontFamily = FontFamily(Font(R.font.circularstdblack)),
                    fontSize = 16.sp
                )
            }
        }
        Box(modifier = Modifier
            .size(300.dp, 300.dp)
            .align(Alignment.BottomCenter),) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 30.dp),
                painter = painterResource(id = backgroundResourceId),
                alignment = Alignment.BottomCenter,
                contentDescription = ""
            )
        }

    }
}

@Composable
fun TextsScreen(name : String, type : String) {
    Column(modifier = Modifier
        .height(IntrinsicSize.Min)
        .padding(vertical = 30.dp), verticalArrangement = Arrangement.Top) {
        Text(text = name, fontSize = 32.sp,fontFamily = FontFamily(Font(R.font.circularstdblack)),color = Color.Black, lineHeight = 40.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(modifier = Modifier, text = type, textAlign = TextAlign.Start, color = Color.Black,
            fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.circularstdbook))
        )
    }
}

@Composable
fun ContinueButtonHome(text_button: String,onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(bottom = 2.dp),
        onClick = { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(contentColor = Color.Transparent, backgroundColor = Color.Black)
    ) { Text(text = text_button, fontWeight = FontWeight.Black, color = Color.White) }
}

@Composable
fun AppBarCustom(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(modifier = Modifier.size(32.dp), imageVector = Icons.Outlined.KeyboardArrowLeft, contentDescription = "", tint = Color.Black)
        Box(
          modifier = Modifier
              .shadow(elevation = 4.dp, shape = CircleShape)
              .size(38.dp)
              .background(Color.Black)
        )
    }
}
