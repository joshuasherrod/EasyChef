package com.example.easychef

import android.app.Application
import androidx.compose.runtime.Composable
import com.example.easychef.ui.navigation.AppNavHost
import com.example.easychef.ui.theme.EasyChefTheme
import dagger.hilt.android.HiltAndroidApp

@Composable
fun EasyChefApp() {
    EasyChefTheme {
        AppNavHost()
    }
}

@HiltAndroidApp
class EasyChefApplication : Application()