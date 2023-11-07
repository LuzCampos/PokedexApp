package com.agileapps.pokedex.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agileapps.pokedex.R
import com.agileapps.pokedex.presentation.viewmodels.HomeViewModel


@Composable
fun SearchComponent(searchText: MutableState<String>, homeViewModel: HomeViewModel, modifier: Modifier) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                shape = RoundedCornerShape(30.dp),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor =
                    Color.Transparent,
                    cursorColor = Color(0xffA4A7AB),
                    focusedBorderColor = MaterialTheme.colors.onSecondary,
                    unfocusedBorderColor = MaterialTheme.colors.onSurface
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.searchicon),
                        contentDescription = "",
                        tint = MaterialTheme.colors.onSecondary,
                        modifier = Modifier
                            .size(20.dp)
                            .padding(start = 4.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                value = searchText.value,
                onValueChange = { searchText.value = it; homeViewModel.searchPokemonByName(it) },
                placeholder = { Text(
                    stringResource(id = R.string.msg_placeholder_searchcomponent),
                    color = MaterialTheme.colors.background,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.circularstdbook)),
                ) },
            )
        }
    }
}