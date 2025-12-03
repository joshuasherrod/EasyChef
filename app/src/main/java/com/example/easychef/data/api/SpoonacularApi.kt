package com.example.easychef.data.api

import com.example.easychef.data.model.RecipeDetail
import com.example.easychef.data.model.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpoonacularApi {

    // Search for recipes
    @GET("recipes/complexSearch")
    suspend fun searchRecipes(
        @Query("query") query: String,
        @Query("number") number: Int = 10,
        @Query("offset") offset: Int = 0,
        @Query("addRecipeInformation") addInfo: Boolean = true,
        @Query("apiKey") apiKey: String
    ): RecipeSearchResponse

    // Get detailed recipe information
    @GET("recipes/{id}/information")
    suspend fun getRecipe(
        @Path("id") id: Int,
        @Query("apiKey") apiKey: String
    ): RecipeDetail
}