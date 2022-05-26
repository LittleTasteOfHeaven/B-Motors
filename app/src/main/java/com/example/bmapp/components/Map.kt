package com.example.bmapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

@Preview(showBackground = true)
@Composable
fun GoogleMapView() {
    val apiKey = "AIzaSyBLJMB5z1WKH08FAVE5Nj_ZcmBEbVQZ_2E"
    val context = LocalContext.current
    
    Places.initialize(context, apiKey)

    val placesClient = Places.createClient(context)
    
    var field = listOf(Place.Field.NAME, Place.Field.ADDRESS)

    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),
    ) {
        GoogleMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.weight(1f)
        ) {
            Marker(
                position = singapore,
                title = "Singapore",
                snippet = "Marker in Singapore"
            )
        }

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Load Location") },
                modifier = Modifier.fillMaxWidth()

            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Unload Location") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}