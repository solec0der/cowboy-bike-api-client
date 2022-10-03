package io.huggler.cowboy.client

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.huggler.cowboy.auth.AuthenticationProvider
import io.huggler.cowboy.client.exception.CowboyException
import io.huggler.cowboy.config.CowboyConstants
import io.huggler.cowboy.model.User
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class CowboyClient(private val authenticationProvider: AuthenticationProvider) {

    private val httpClient = HttpClient.newBuilder().build()
    private val objectMapper = jacksonObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    fun getUser(): User {
        val requestBuilder = HttpRequest.newBuilder()
            .uri(URI(CowboyConstants.API_BASE_URL + CowboyConstants.USER_ENDPOINT))
            .GET()

        authenticationProvider.getAuth().getAsHeaders().forEach { (key, value) ->
            requestBuilder.header(key, value)
        }

        val request = requestBuilder.build()
        val response = httpClient.send(request, BodyHandlers.ofString())

        if (response.statusCode() != 200) {
            throw CowboyException("Failed to get user", response.statusCode())
        }
        return objectMapper.readValue(response.body(), User::class.java)
    }
}