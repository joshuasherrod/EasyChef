package com.example.easychef.ui.features.recipesearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easychef.BuildConfig
import com.example.easychef.data.api.SpoonacularApi
import com.example.easychef.data.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RecipeSearchUiState(
    val isLoading: Boolean = false,
    val results: List<Recipe> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class RecipeSearchViewModel @Inject constructor(
    private val api: SpoonacularApi
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecipeSearchUiState())
    val uiState: StateFlow<RecipeSearchUiState> = _uiState

    fun searchRecipes(query: String) {
        if (query.isBlank()) return

        viewModelScope.launch {
            _uiState.value = RecipeSearchUiState(isLoading = true)

            try {
                val response = api.searchRecipes(
                    query = query,
                    apiKey = BuildConfig.SPOONACULAR_API_KEY
                )
                _uiState.value = RecipeSearchUiState(
                    isLoading = false,
                    results = response.results,
                    error = null
                )
            } catch (e: Exception) {
                _uiState.value = RecipeSearchUiState(
                    isLoading = false,
                    results = emptyList(),
                    error = e.localizedMessage ?: "Something went wrong"
                )
            }
        }
    }
}