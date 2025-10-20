package com.example.easychef.ui.features.loginscreen

import android.preference.PreferenceScreen
import com.example.easychef.ui.components.AppLogo
import com.example.easychef.ui.components.TextBox
import com.example.easychef.ui.components.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun LoginScreen(onGoToHome: (String) -> Unit, onGoToPreferenceScreen: (String) -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(1f),
        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLogo(
            modifier = Modifier
                .wrapContentSize(),
            appVer = false
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextBox(modifier = Modifier
            .wrapContentSize(),
            label = "Username",
            onValueChange = { username = it },
            text = username
            )
        TextBox(modifier = Modifier
            .wrapContentSize(),
            label = "Password",
            onValueChange = { password = it },
            text = password
        )
        Row(
            modifier = Modifier.fillMaxWidth(1f),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // TODO: Use auth to process information and clear fields, and use SnackBar to inform user when fields are incorrect/missing
            Button(onClick = {
                // Temporary strings for testing navigation, replace with the SupaBase Auth so their homepage/preferences has their data
                onGoToHome("TestID")
            }, text = "Log In")
            Button(onClick = {
                // Add a conditional that will not call the nav to preferences screen if user/pass combo is already valid in the DB
                onGoToPreferenceScreen("TestID")
            }, text = "Sign Up")
        }
        Spacer(modifier = Modifier.height(100.dp))
    }


}