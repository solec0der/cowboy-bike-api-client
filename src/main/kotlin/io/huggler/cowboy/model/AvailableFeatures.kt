package io.huggler.cowboy.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AvailableFeatures(
    val theftAlerts: Boolean,
    val autoUnlock: Boolean,
    val crashDetection: Boolean
)
