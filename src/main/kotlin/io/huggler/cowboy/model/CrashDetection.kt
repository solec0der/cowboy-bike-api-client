package io.huggler.cowboy.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CrashDetection(
    val maxContacts: Int,
    val contacts: List<Contact>
)
