package com.example.bmapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Service(navController: NavController, categoryName: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$categoryName Vehicle",
            fontSize = 30.sp,
        )
        OutlinedButton(onClick = {}) {
            Text(text = "Select Location with Maps")
        }
        TextField(value = "", onValueChange = {}, label = {
            Text(
                text = "Phone Number"
            )
        })
    }
}
