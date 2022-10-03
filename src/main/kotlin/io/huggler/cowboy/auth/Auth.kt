package io.huggler.cowboy.auth

data class Auth(
    val accessToken: String,
    val client: String,
    val uid: String,
    val expiry: Long
) {
    fun getAsHeaders(): Map<String, String> {
        return mapOf(
            "Access-Token" to accessToken,
            "X-Cowboy-App-Token" to "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9",
            "Client" to client,
            "Client-Type" to "Android-App",
            "Uid" to uid
        )
    }
}
