package com.example.otus_kmm.Services

import kotlinx.serialization.json.Json
import com.example.otus_kmm.apis.RecipeApi
import io.ktor.client.*

class NetworkService {
    val recipeApi = RecipeApi(
        basePath = "http://www.recipepuppy.com/",
        httpClient = HttpClient(),
        json = Json { ignoreUnknownKeys = true }
    )

}