package io.huggler.cowboy.client.exception

class CowboyException(message: String, private val statusCode: Int) : RuntimeException(message) {

    fun getStatusCode(): Int {
        return statusCode
    }
}