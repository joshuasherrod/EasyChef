package com.example.easychef.data.model

data class RecipeDetail(
    val id: Int,
    val title: String,
    val image: String?,
    val summary: String?,
    val instructions: String? = null
)