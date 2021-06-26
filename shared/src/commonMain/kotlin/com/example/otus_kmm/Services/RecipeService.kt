package com.example.otus_kmm.Services

import com.example.otus_kmm.models.RecipeList

class RecipeService {
    private val networkService = NetworkService()

    suspend fun searchRecipes(query: String, withPics: Boolean): RecipeList {
        return networkService.recipeApi.getRecipe(query, null, 1)
    }
}