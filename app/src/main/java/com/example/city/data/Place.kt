package com.example.city.data

import androidx.annotation.StringRes

data class Place(
    val id: Int,
    val title: String,
    @StringRes val description: Int,
    val image: Int
)
