package com.agileapps.pokedex.presentation.componentes.floatingbutton

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.agileapps.pokedex.R
import com.agileapps.pokedex.presentation.componentes.modalbottomsheet.BottomSheetType

@Composable
fun MultiFloatingButton(
    multiFloatingState: MultiFloatingState,
    onMultiFabStateChange:(MultiFloatingState) -> Unit,
    items: List<FabItem>,
    onClick: (BottomSheetType) -> Unit,
){
    Column (horizontalAlignment = Alignment.End, modifier = Modifier.padding(bottom = 20.dp)) {
        if (multiFloatingState == MultiFloatingState.Expanded){
            items.forEach {
                FilterItems(fabItem = it,
                    onFabItemClick = { fabItem ->
                        val bottomSheetType = BottomSheetType.valueOf(fabItem.identifier)
                        onClick(bottomSheetType)
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
                    contentDescription = "R.drawable.filter",
                    tint = MaterialTheme.colors.primaryVariant,
                    modifier = Modifier.size(22.dp)
                )
                MultiFloatingState.Expanded ->
                    Icon(
                        painter = painterResource(id = R.drawable.x),
                        contentDescription = "R.drawable.x",
                        tint = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier.size(16.dp)
                    )
            }
        }
    }
}

@Composable
fun FilterItems(
    fabItem: FabItem,
    onFabItemClick: (FabItem) -> Unit
){
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(40.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier.clickable {
            onFabItemClick.invoke(fabItem)
        }
    ) {
        Row(modifier = Modifier.padding(horizontal = 18.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = stringResource(id = fabItem.label), color = MaterialTheme.colors.onSecondary)
            Spacer(modifier = Modifier.size(12.dp))
            Image(
                ImageBitmap.imageResource(fabItem.icon),
                contentDescription = "fav",
                modifier = Modifier.size(14.dp)
            )
        }
    }
}