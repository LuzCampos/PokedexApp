package com.agileapps.pokedex.presentation.onboarding

import androidx.annotation.ColorLong
import androidx.annotation.DrawableRes
import com.agileapps.pokedex.R

data class UserRatingState(
    val name:Int,
    @ColorLong val backgroundColor: Long,
    @DrawableRes val backgroundResourceId: Int,
    val type:Int,
    val punctuation:Double,
    val titleImg:Int,
    val winRate :Int
)

val mysticMaster = UserRatingState(
    name = R.string.msg_name_mysticMaster, backgroundColor = 0xff0079FF, backgroundResourceId = R.drawable.mystic,
    type = R.string.msg_type_mysticMaster,
    punctuation = 9.8, titleImg = R.string.msg_titleImg_mysticMaster, winRate = 92,
)
