package com.example.otus_kmm.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

/**
 *
 * @param title
 * @param href
 * @param ingredients
 * @param thumbnail
 */
@Serializable
data class Recipe (
    @SerialName("href")
    val href: kotlin.String,
    @SerialName("title")
    val title: kotlin.String? = null,
    @SerialName("ingredients")
    val ingredients: kotlin.String? = null,
    @SerialName("thumbnail")
    val thumbnail: kotlin.String? = null
) {

}
