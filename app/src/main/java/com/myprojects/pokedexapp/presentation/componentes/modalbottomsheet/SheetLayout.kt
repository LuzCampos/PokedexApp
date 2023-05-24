package com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel

@Composable
fun SheetLayout(
    bottomSheetType: BottomSheetType,
    searchText: MutableState<String>, homeViewModel: HomeViewModel,
    generation: List<Generation>,
    type: List<Type>,
){
    when(bottomSheetType){
        BottomSheetType.TYPE1 -> SearchComponent(searchText,homeViewModel)
        BottomSheetType.TYPE2 -> AllType(type,homeViewModel)
        BottomSheetType.TYPE3 -> AllGen(generation,homeViewModel)
    }

}