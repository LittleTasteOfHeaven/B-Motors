package com.example.bmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmapp.ui.theme.BMAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home() {
    Column {
        Header()
        Spacer(modifier = Modifier.size(24.dp))
        Categories()
    }
}

@Composable
fun Header() {
    val logo = painterResource(id = R.drawable.logo)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(24.dp))
        Image(
            painter = logo,
            contentDescription = "Icon for the app",
            modifier = Modifier.size(80.dp)
        )
        Text(
            text = "Bangla Motors", fontSize = 36.sp
        )
    }
}

data class Category(val imageID: Int, val name: String)

const val truckImageID = R.drawable.categoryplaceholder

val categoryList = listOf<Category>(
    Category(truckImageID, "Pickup"),
    Category(truckImageID, "Covered"),
    Category(truckImageID, "Cement"),
    Category(truckImageID, "Freezer"),
    Category(truckImageID, "Trailer"),
    Category(truckImageID, "Crane")
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Categories() {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 144.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(24.dp)
    ) {
        items(6) { index ->
            OutlinedButton(
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color(0xeeeeeeff)
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 8.dp
                    )
                ) {
                    Image(
                        painter = painterResource(
                            id = categoryList[index].imageID
                        ),
                        contentDescription = "hih",
                        modifier = Modifier.size(64.dp)
                    )
                    Text(
                        text = categoryList[index].name,
                        fontSize = 24.sp
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BMAppTheme() {
        Home()
    }
}