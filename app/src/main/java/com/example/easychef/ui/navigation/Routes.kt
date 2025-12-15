package com.example.easychef.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object LoginScreen

@Serializable
data class HomeScreen(
    val id: String
)

@Serializable
data class Preferences(
    val id: String
)

@Serializable
object Pantry

@Serializable
object RecipeSearch