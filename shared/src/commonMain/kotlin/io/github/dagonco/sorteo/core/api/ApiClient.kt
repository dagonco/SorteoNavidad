package io.github.dagonco.sorteo.core.api

import io.github.dagonco.sorteo.commons.Either
import io.github.dagonco.sorteo.core.di.body
import io.github.dagonco.sorteo.core.di.client
import io.github.dagonco.sorteo.core.domain.ApiError
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.URLProtocol
import io.ktor.http.path
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class ApiRequest<Response : Any> {
    abstract val host: String
    abstract val path: String
    open val queryParams: Map<String, String> = emptyMap()
}

class ApiClient {

    suspend inline fun <reified Response : Any> sendRequest(
        request: ApiRequest<Response>,
    ): Either<ApiError, Response> = withContext(Dispatchers.Default) {

        try {

            val response = client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = request.host
                    path(request.path)
                    request.queryParams.forEach { parameter(it.key, it.value) }
                }
            }.body<Response>()

            Either.Right(response)
        } catch (exception: Exception) {
            val apiError = ApiError(exception.message.toString())
            Either.Left(apiError)
        }
    }
}
