package io.huggler.cowboy.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Settings(
    val referralProgram: Boolean,
    val distanceUnits: String,
    val temperatureUnits: String,
    val weightUnits: String
)
