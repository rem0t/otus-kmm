package com.example.otus_kmm.apis

import com.example.otus_kmm.models.ErrorModel
import com.example.otus_kmm.models.RecipeList

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.takeFrom
import kotlinx.serialization.json.Json
import io.ktor.client.call.ReceivePipelineException

class RecipeApi(basePath: kotlin.String = "http://www.recipepuppy.com", httpClient: HttpClient, json: Json) {

    private val _basePath = basePath
    private val _httpClient = httpClient
    private val _json = json

    /**
     * Get Recipe
     *
     * @param i Ingredient
     * @param q Query (optional)
     * @param p Paging (optional)
     * @return RecipeList
     */
    @Suppress("UNCHECKED_CAST")
    suspend fun getRecipe(i: String, q: String?, p: Int?) : RecipeList {
        val builder = HttpRequestBuilder()

        builder.method = HttpMethod.Get
        builder.url {
            takeFrom(_basePath)
            encodedPath = encodedPath.let { startingPath ->
                path("api/")
                return@let startingPath + encodedPath.substring(1)
            }
            @Suppress("UNNECESSARY_SAFE_CALL")
            with(parameters) {
                i?.let { append("i", it.toString()) }
                q?.let { append("q", it.toString()) }
                p?.let { append("p", it.toString()) }
            }
        }

        with(builder.headers) {
            append("Accept", "application/json")
        }

        try {
            //not primitive type
            val result: String = _httpClient.request(builder)
            return _json.decodeFromString(RecipeList.serializer(), result)
        } catch (pipeline: ReceivePipelineException) {
            throw pipeline.cause
        }
    }

}