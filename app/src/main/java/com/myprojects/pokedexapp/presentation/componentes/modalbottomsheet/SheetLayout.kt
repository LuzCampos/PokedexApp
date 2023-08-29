package com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.myprojects.pokedexapp.presentation.common.SearchComponent
import com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet.generation.AllGen
import com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet.generation.Generation
import com.myprojects.pokedexapp.presentation.home.type.Type
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel

@Composable
fun SheetLayout(
    bottomSheetType: BottomSheetType,
    searchText: MutableState<String>, homeViewModel: HomeViewModel,
    generation: List<Generation>,
    type: List<Type>,
    modifier:Modifier
){
    when(bottomSheetType){
        BottomSheetType.TYPE1 -> SearchComponent(searchText,homeViewModel, modifier)
        BottomSheetType.TYPE2 -> AllType(type,homeViewModel)
        BottomSheetType.TYPE3 -> AllGen(generation,homeViewModel)
    }

}