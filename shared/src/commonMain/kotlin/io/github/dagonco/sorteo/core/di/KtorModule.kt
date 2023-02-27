package io.github.dagonco.sorteo.core.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

val json = Json {
    ignoreUnknownKeys = true
}

val client: HttpClient = HttpClient {
    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.BODY
    }
}

suspend inline fun <reified T> HttpResponse.body(): T {
    val response = bodyAsText().substringAfter("=")
    return json.decodeFromString(response)
}