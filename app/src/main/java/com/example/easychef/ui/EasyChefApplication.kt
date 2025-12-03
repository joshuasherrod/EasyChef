package com.example.easychef.ui

import androidx.compose.runtime.Composable
import com.example.easychef.ui.navigation.AppNavHost
import com.example.easychef.ui.theme.EasyChefTheme

@Composable
fun EasyChefApp() {
    EasyChefTheme {
        AppNavHost()
    }
}