package io.huggler.cowboy.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Position(
    val latitude: Float,
    val longitude: Float,
    val accuracy: Float,
    val createdAt: String,
    val receivedAt: String,
    val address: String,
    val source: String,
    val elevation: String?,
    val id: Float,
    val type: String
)
