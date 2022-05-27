package com.example.bmapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.navigation.NavController
import com.example.bmapp.dataStore
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map

@Composable
fun Service(navController: NavController, categoryName: String) {
    val dataStore = LocalContext.current.dataStore
    val (phoneSt, setPhoneSt) = remember { mutableStateOf("") }

    LaunchedEffect(true) {
        val phonePref = stringPreferencesKey("phoneNumber")

        dataStore.edit { settings ->
            settings[phonePref] = "01934444444"
        }

        val phone = dataStore.data.map { preferences ->
            preferences[phonePref] ?: ""
        }
        try {
            phone.collect {
                setPhoneSt(it)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

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
        TextField(value = phoneSt, onValueChange = {}, label = {
            Text(
                text = "Phone Number"
            )
        })
    }
}
