package com.example.otus_kmm.models

import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

/**
 *
 * @param message
 * @param code
 */
@Serializable
data class ErrorModel (
    @SerialName("message")
    val message: kotlin.String,
    @SerialName("code")
    val code: kotlin.Int
) {

}
