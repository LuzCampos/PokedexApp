package com.agileapps.pokedex.presentation.onboarding

import com.agileapps.pokedex.R

data class WelcomeScreenState(
    val title : Int,
    val description : Int,
    val text_button : Int
)

val welcomeState = WelcomeScreenState(
    title = R.string.msg_title_welcomescreenstate, description = R.string.msg_desc_welcomescreenstate, text_button = R.string.msg_textbutton_welcomescreenstate)
