package com.example.otus_kmm.models

import com.example.otus_kmm.models.Recipe
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

/**
 *
 * @param title
 * @param results
 */
@Serializable
data class RecipeList (
    @SerialName("title")
    val title: kotlin.String? = null,
    @SerialName("results")
    val results: kotlin.collections.List<Recipe>? = null
) {

}


