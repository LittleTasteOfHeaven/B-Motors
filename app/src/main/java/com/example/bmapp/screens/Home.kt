package com.example.bmapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bmapp.components.Categories
import com.example.bmapp.components.Header

@Composable
fun Home() {
    Column {
        Header()
        Spacer(modifier = Modifier.size(24.dp))
        Categories()
    }
}