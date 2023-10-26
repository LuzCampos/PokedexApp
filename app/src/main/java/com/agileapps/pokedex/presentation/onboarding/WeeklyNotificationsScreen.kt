package com.agileapps.pokedex.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.agileapps.pokedex.R

@Composable
fun WeeklyNotificationsScreen(state: WeeklyNotificationsScreenState,navigateTo: () -> Unit){
    val backgroundColorInside = state.backgroundColorInside
    val backgroundColorOutside = state.backgroundColorOutside
    val imageScreen = state.imageScreen
    val toprightText = state.toprightText
    val bottomleftIcon = state.bottomleftIcon
    val title = state.title
    val content = state.content
    val topBottomFade = Brush.verticalGradient(0.6f to Color.Red, 1f to Color.Transparent)
    println(content.length)

    val largeRadialGradient = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(
                    //Color(0xFF2be4dc),
                    Color(backgroundColorInside),
                    Color(backgroundColorOutside),
                    //Color(0xFF243484)),
                ),
                center = size.center,
                radius = biggerDimension / 2f,
                colorStops = listOf(0f, 0.95f)
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(largeRadialGradient)
    ){

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 36.dp)
                .padding(bottom = 26.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                modifier = Modifier
                    .size(170.dp),
                alignment = Alignment.Center,
                painter = painterResource(id = imageScreen),
                contentDescription = "" )
            Column(modifier = Modifier.padding(top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = title, color = Color(0xff272822),
                    fontFamily = FontFamily(Font(R.font.hapticproblack)),
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 38.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                if (content.length < 140)
                    TextContent(Modifier.height(120.dp),title, content)
                else TextContent(
                    Modifier
                        .padding(top = 6.dp)
                        .height(140.dp)
                        .fadingEdge(topBottomFade), title, content)
                //Text(text = "$content \uD83D\uDCF2✨.", color = Color(0xff272822), fontFamily = FontFamily(Font(R.font.hapticproregular)), fontSize = 18.sp, lineHeight = 22.sp, textAlign = TextAlign.Justify)
            }

        }
        // PokeBallBackground()
        NumberNotification(toprightText)
        //MyButton()
        CustomButton(bottomleftIcon){
            navigateTo()
        }
    }

}

@Composable
fun BoxScope.NumberNotification(text:String){
    Box(modifier = Modifier
        .align(Alignment.TopEnd)
        .size(218.dp)
        .offset(x = 30.dp, y = -50.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            painter = painterResource(R.drawable.pokeballbackground),
            contentDescription = "Pokeball Shadow",
            colorFilter = ColorFilter.tint(color = Color(0xff303943).copy(0.06f))
        )
        Text(
            text ="#$text",
            textAlign = TextAlign.Center,
            color = Color(0xff272822).copy(.4f),
            modifier = Modifier
                .align(Alignment.Center),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.hapticproextrabold))
        )
    }
}

@Composable
fun BoxScope.CustomButton(leftIcon:Int, onClick : () -> Unit){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)
        .align(Alignment.BottomCenter)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .padding(bottom = 80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Box() {
                Image(
                    modifier = Modifier
                        .height(80.dp)
                        .padding(start = 6.dp),
                    contentScale = ContentScale.Inside,
                    painter = painterResource(id = leftIcon), contentDescription = "" )
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .border(5.dp, Color.White.copy(alpha = 0.18f), CircleShape)
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(Color.Transparent),
                //modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 40.dp).size(110.dp).border(2.dp, Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { onClick() },
                    modifier = Modifier
                        .size(80.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.nexticon),
                        contentDescription = ""
                    )
                }
            }
}}}



@Composable
fun TextContent(modifier: Modifier,title : String, content: String) {
    LazyColumn(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start){
        item {
            Box(
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 12.dp),
                    text = content,
                    textAlign = TextAlign.Left,
                    color = Color(0xff242c33),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.circularstdbook)),
                    lineHeight = 24.sp
                )
            }
        }
    }


}

fun Modifier.fadingEdge(brush: Brush) = this
    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
    .drawWithContent {
        drawContent()
        drawRect(brush = brush, blendMode = BlendMode.DstIn)
    }

@Composable
fun FadingEdgeExamples() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val topFade = Brush.verticalGradient(0f to Color.Transparent, 0.3f to Color.Red)
        Box(modifier = Modifier
            .fadingEdge(topFade)
            .background(Color.Blue)
            .size(100.dp))

        val topBottomFade = Brush.verticalGradient(0f to Color.Transparent, 0.3f to Color.Red, 0.7f to Color.Red, 1f to Color.Transparent)
        Box(modifier = Modifier
            .fadingEdge(topBottomFade)
            .background(Color(0xffffcccc))
            .size(100.dp))

        val leftRightFade = Brush.horizontalGradient(0f to Color.Transparent, 0.1f to Color.Red, 0.9f to Color.Red, 1f to Color.Transparent)
        Box(modifier = Modifier
            .fadingEdge(leftRightFade)
            .background(Color.Blue)
            .size(100.dp))

        val radialFade = Brush.radialGradient(0f to Color.Red, 0.5f to Color.Transparent)
        Box(modifier = Modifier
            .fadingEdge(radialFade)
            .background(Color.Blue)
            .size(100.dp))

            }
        }
