package io.huggler.cowboy.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Bike(
    val id: Long,
    val macAddress: String,
    val stolen: Boolean,
    val firmwareVersion: String,
    val activatedAt: String,
    val passkey: String,
    val nickname: String,
    val crashed: Boolean,
    val seenAt: String,
    val skuCode: String,
    val lastCrashStartedAt: String?,
    val autonomy: Float,
    val batteryStateOfChargeUpdatedAt: String,
    val batteryStateOfCharge: Float,
    val pcbBatteryStateOfCharge: Float,
    val serialNumber: String,
    val totalDistance: Float,
    val totalDuration: Float,
    val totalCo2Saved: Float,
    val position: Position,
    val insuranceConditions: InsuranceConditions,
    val availableFeatures: AvailableFeatures,
    val durationModifier: Float,
    val model: Model
)
