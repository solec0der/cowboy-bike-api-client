package io.huggler.cowboy.auth

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.huggler.cowboy.client.exception.AuthenticationException
import io.huggler.cowboy.config.CowboyConstants
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class AuthenticationProvider(
    private val email: String,
    private val password: String
) {
    private val httpClient = HttpClient.newHttpClient()
    private val objectMapper = jacksonObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    private var auth: Auth? = null

    fun getAuth(): Auth {
        if (auth == null) {
            authenticate()
        }
        return auth!!
    }

    private fun authenticate() {
        val credentials = mapOf(
            "email" to email,
            "password" to password
        )

        val authRequest = HttpRequest.newBuilder()
            .uri(URI(CowboyConstants.API_BASE_URL + "/auth/sign_in"))
            .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(credentials)))
            .header("Content-Type", "application/json")
            .header("Client", "Android-App")
            .header("Client-Type", "Android-App")
            .build()

        val response = httpClient.send(authRequest, HttpResponse.BodyHandlers.ofString())

        if (response.statusCode() != 200) {
            throw AuthenticationException("Authentication failed")
        }

        auth = Auth(
            accessToken = response.headers().firstValue("Access-Token").get(),
            client = response.headers().firstValue("Client").get(),
            uid = response.headers().firstValue("Uid").get(),
            expiry = response.headers().firstValue("Expiry").get().toLong()
        )
    }
}