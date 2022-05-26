package com.example.bmapp.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bmapp.data.categoryList

fun handleClick(navController: NavController, categoryIndex: Int) {
    navController.navigate(
        route = "services?categoryName=${
            categoryList[categoryIndex].name
        }"
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Categories(navController: NavController) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 144.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(24.dp)
    ) {
        items(6) { idx ->
            OutlinedButton(
                onClick = {
                    handleClick(
                        navController = navController, categoryIndex = idx
                    )
                }, colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color(0xeeeeeeff)
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(
                        horizontal = 10.dp, vertical = 8.dp
                    )
                ) {
                    Image(
                        painter = painterResource(
                            id = categoryList[idx].image.id
                        ),
                        contentDescription = categoryList[idx].image.desc,
                        modifier = Modifier.size(64.dp)
                    )
                    Text(
                        text = categoryList[idx].name, fontSize = 24.sp
                    )
                }

            }
        }
    }
}