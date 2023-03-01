package com.example.gridviewpractice.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicStringId: Int,
    val topicInt: Int,
    @DrawableRes val topicImageId: Int
)
