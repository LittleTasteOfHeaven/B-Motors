package com.example.bmapp.data

import com.example.bmapp.R

data class Category(val imageID: Int, val name: String)

const val truckImageID = R.drawable.categoryplaceholder

val categoryList = listOf(
    Category(truckImageID, "Pickup"),
    Category(truckImageID, "Covered"),
    Category(truckImageID, "Cement"),
    Category(truckImageID, "Freezer"),
    Category(truckImageID, "Trailer"),
    Category(truckImageID, "Crane")
)