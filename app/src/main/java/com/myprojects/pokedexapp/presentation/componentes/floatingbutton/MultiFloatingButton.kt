package com.myprojects.pokedexapp.presentation.componentes.floatingbutton

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet.BottomSheetType

@Composable
fun MultiFloatingButton(
    multiFloatingState: MultiFloatingState,
    onMultiFabStateChange:(MultiFloatingState) -> Unit,
    context: Context,
    items: List<FabItem>,
    onClick1: () -> Unit,
    onClick2:()->Unit,
    onClick3:()->Unit,
){
    Column (horizontalAlignment = Alignment.End) {
        if (multiFloatingState == MultiFloatingState.Expanded){
            items.forEach { 
                Filteritems(fabItem = it,
                    onFabItemClick = { fabItem ->
                           when(fabItem.identifier){
                               BottomSheetType.TYPE1.name -> {
                                   Toast.makeText(context, "FAVORITES",Toast.LENGTH_SHORT).show()
                                   onClick1()
                               }
                               BottomSheetType.TYPE2.name -> {
                                   Toast.makeText(context, "TYPES",Toast.LENGTH_SHORT).show()
                                    onClick2()
                               }
                               BottomSheetType.TYPE3.name -> {
                                   Toast.makeText(context, "GENERATION",Toast.LENGTH_SHORT).show()
                                   onClick3()
                               }
                           }
                    }
                )
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
        FloatingActionButton(
            backgroundColor = Color(0xff6C79DB),
            onClick = {
                onMultiFabStateChange(
                    if (multiFloatingState == MultiFloatingState.Expanded) {
                        MultiFloatingState.Collapsed
                    } else {
                        MultiFloatingState.Expanded
                    }
                )
            },

            ) {
            when (multiFloatingState) {
                MultiFloatingState.Collapsed -> Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(22.dp)
                )
                MultiFloatingState.Expanded ->
                    Icon(
                        painter = painterResource(id = R.drawable.x),
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
            }
        }
    }
}

@Composable
fun Filteritems(
    fabItem: FabItem,
    onFabItemClick: (FabItem) -> Unit
    ){
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(40.dp),
        backgroundColor = Color.White,
        modifier = Modifier.clickable {
            onFabItemClick.invoke(fabItem)
        }
    ) {
        Row(modifier = Modifier.padding(horizontal = 18.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = fabItem.label, color = Color(0xff303943))
            Spacer(modifier = Modifier.size(12.dp))
            Image(
                ImageBitmap.imageResource(fabItem.icon),
                contentDescription = "fav",
                modifier = Modifier.size(14.dp)
            )
        }
    }
}