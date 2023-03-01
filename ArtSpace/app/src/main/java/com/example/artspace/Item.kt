package com.example.artspace

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Item(
    @DrawableRes val image: Int,
    @StringRes val imageName: Int,
    @StringRes val imageCapturedBy: Int
)
