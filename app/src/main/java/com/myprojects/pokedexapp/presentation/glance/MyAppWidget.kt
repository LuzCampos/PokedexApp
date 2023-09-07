package com.myprojects.pokedexapp.presentation.glance

import androidx.glance.layout.*
import androidx.compose.runtime.Composable
import androidx.glance.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.background
import com.myprojects.pokedexapp.MainActivity
import com.myprojects.pokedexapp.R


class MyAppWidget : GlanceAppWidget() {

   @Composable
   override fun Content(){

       Column(
           modifier = GlanceModifier.fillMaxSize().background(day = Color(0xffE5B12D), night = Color(0xff303943)).padding(vertical = 20.dp, horizontal = 14.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
            verticalAlignment = Alignment.CenterVertically

       ) {
           Box(
               contentAlignment = Alignment.Center,
               modifier = GlanceModifier.padding(vertical = 20.dp).clickable(
                   onClick = actionStartActivity<MainActivity>()
               )
           ) {
               Image(
                   provider = ImageProvider(R.drawable.pokeballbackground),
                   contentDescription = "",
                   modifier = GlanceModifier.size(80.dp)
               )
               Image(
                   provider = ImageProvider(R.drawable.pikachu_3x),
                   contentDescription = "",
                   modifier = GlanceModifier.size(74.dp)
               )
           }
       }
   }

}













