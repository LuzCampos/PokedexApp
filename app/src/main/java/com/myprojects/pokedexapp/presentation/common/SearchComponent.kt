package com.myprojects.pokedexapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel
import kotlinx.coroutines.delay


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchComponent(searchText: MutableState<String>, homeViewModel: HomeViewModel, modifier: Modifier) {

    val showKeyboard = remember { mutableStateOf(true) }
    val focusRequester = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                shape = RoundedCornerShape(30.dp),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xffF1F1F1),
                    cursorColor = Color(0xffA4A7AB),
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.searchicon),
                        contentDescription = "",
                        tint = Color(0xff303943),
                        modifier = Modifier
                            .size(20.dp)
                            .padding(start = 4.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth().height(48.dp)
                    .focusRequester(focusRequester),
                value = searchText.value,
                onValueChange = { searchText.value = it; homeViewModel.searchPokemonByName(it) },
                placeholder = { Text(
                    "Search Pokemon, Move, Ability etc",
                    color = Color(0xffA4A7AB),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.circularstdbook)),
                ) }
            )

            LaunchedEffect(focusRequester) {
                if (showKeyboard.value) {
                    focusRequester.requestFocus()
                    delay(100)
                    keyboard?.show()
                }
            }
        }
    }
}