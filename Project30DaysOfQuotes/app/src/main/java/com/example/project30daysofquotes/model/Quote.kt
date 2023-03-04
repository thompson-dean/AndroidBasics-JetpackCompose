package com.example.project30daysofquotes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Quote(
    var index: Int,
    val author: String,
    val quote: String,
    @DrawableRes val image: Int
)
