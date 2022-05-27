package com.example.bmapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.navigation.NavController
import com.example.bmapp.dataStore
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map

@Composable
fun Service(navController: NavController, categoryName: String) {
    val dataStore = LocalContext.current.dataStore
    val (verifiedSt, setVerifiedSt) = remember { mutableStateOf(false) }
    val (verifyPhoneCardSt, setVerifyPhoneCardSt) = remember {
        mutableStateOf(
            false
        )
    }
    val (otpSt, setOtpSt) = remember { mutableStateOf("") }
    val (phoneSt, setPhoneSt) = remember { mutableStateOf("") }

    LaunchedEffect(true) {
        val phonePref = stringPreferencesKey("phoneNumber")

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

        when (verifiedSt) {
            true -> {}
            false -> {
                OutlinedButton(onClick = { setVerifyPhoneCardSt(true) }) {
                    Text(text = "Verify")
                }
            }
        }
    }

    when (verifyPhoneCardSt) {
        true -> {
            Dialog(onDismissRequest = { setVerifyPhoneCardSt(false) }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = Color(0xFFF5F5F5))
                        .padding(15.dp)
                ) {
                    Text(text = "Enter the otp sent to your phone number $phoneSt")
                    TextField(
                        value = otpSt,
                        onValueChange = { setOtpSt(it) },
                        label = {
                            Text(
                                text = "OTP"
                            )
                        }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            10.dp,
                            alignment = Alignment.End
                        )
                    ) {

                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Verify")
                        }
                        Button(onClick = { setVerifyPhoneCardSt(false) }) {
                            Text(text = "Cancel")
                        }
                    }
                }
            }
        }

        false -> {
        }
    }
}
