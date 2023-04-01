package com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.myprojects.pokedexapp.presentation.componentes.floatingbutton.MultiFloatingState
import com.myprojects.pokedexapp.presentation.home.Screen1
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel

@Composable
fun SheetLayout(
    bottomSheetType: BottomSheetType,
    closeSheet : () -> Unit,
    searchText: MutableState<String>, homeViewModel: HomeViewModel,
    generation: List<Generation>,
    fabItemState: MultiFloatingState,
){
    when(bottomSheetType){
        BottomSheetType.TYPE1 -> Screen1(closeSheet, searchText,homeViewModel, fabItemState)
        BottomSheetType.TYPE2 -> AllGen(closeSheet,generation,homeViewModel)
        BottomSheetType.TYPE3 -> AllGen(closeSheet,generation,homeViewModel)
    }

}