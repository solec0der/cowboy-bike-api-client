package io.huggler.cowboy.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class User(
    val id: Long,
    val countryCode: String?,
    val phoneNumber: String?,
    val provider: String?,
    val settings: Settings,
    val facebookProfileUrl: String?,
    val instagramUsername: String?,
    val investorNumber: String?,
    val uid: String,
    val createdAt: String,
    val updatedAt: String,
    val role: String,
    val firstName: String,
    val lastName: String,
    val nickname: String,
    val uuid: String,
    val biography: String?,
    val syncAppleHealth: Boolean,
    val syncGoogleFit: Boolean,
    val profileLink: String,
    val syncStrava: Boolean,
    val totalDistance: Float,
    val totalDuration: Float,
    val totalCo2Saved: Float,
    val firstBikeAssignedAt: String,
    val intercomToken: String,
    val subscription: Map<String, Any>?,
    val activeSubscriptions: List<Map<String, Any>>,
    val crashDetection: CrashDetection,
    val availablePlans: List<Map<String, Any>>,
    val availableLanguages: List<String>,
    val humanEfficiencyFactor: Float,
    val referralLink: String?,
    val socialFeatures: Boolean,
    val emergencyPhoneNumber: String,
    val avatarUrl: String?,
    val avatars: String?,
    val coverUrl: String?,
    val instagramProfileUrl: String?,
    val facebookUsername: String?,
    val stravaAuthorized: Boolean,
    val bike: Bike

)
