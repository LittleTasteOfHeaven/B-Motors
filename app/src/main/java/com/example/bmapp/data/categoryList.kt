package com.example.bmapp.data

import com.example.bmapp.R

data class Image(val id: Int, val desc: String)

data class Category(val image: Image, val name: String)

const val truckImageID = R.drawable.categoryplaceholder

val categoryList = listOf(
    Category(Image(truckImageID, "some"), "Pickup"),
    Category(Image(truckImageID, "some"), "Covered"),
    Category(Image(truckImageID, "some"), "Cement"),
    Category(Image(truckImageID, "some"), "Freezer"),
    Category(Image(truckImageID, "some"), "Trailer"),
    Category(Image(truckImageID, "some"), "Crane")
)