package com.example.easychef.data.model

data class RecipeSearchResponse(
    val results: List<Recipe>,
    val offset: Int,
    val number: Int,
    val totalResults: Int
)