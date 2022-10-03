package io.huggler.cowboy.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Contact(
    val id: Long,
    val fullName: String,
    val phoneNumber: String,
    val clientLanguage: String
)
