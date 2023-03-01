package com.example.artspace

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes



class DataManager {
    val dataArray: Array<Item> = arrayOf(
        Item(
            image = R.drawable.snow_monkey,
            imageName = R.string.snow_monkey,
            imageCapturedBy = R.string.dean
        ),
        Item(
            image = R.drawable.lake,
            imageName = R.string.lake,
            imageCapturedBy = R.string.waldo
        ),
        Item(
            image = R.drawable.frozen_grass,
            imageName = R.string.frozen_grass,
            imageCapturedBy = R.string.jazz
        )
    )

}