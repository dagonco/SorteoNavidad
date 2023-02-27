package io.github.dagonco.sorteo.navidad.api

import io.github.dagonco.sorteo.commons.Either
import io.github.dagonco.sorteo.core.api.ApiClient
import io.github.dagonco.sorteo.core.domain.ApiError
import io.github.dagonco.sorteo.navidad.api.request.GetResultRequest
import io.github.dagonco.sorteo.navidad.api.request.GetResultResponse
import io.github.dagonco.sorteo.navidad.api.request.GetStatusRequest
import io.github.dagonco.sorteo.navidad.api.request.GetStatusResponse
import io.github.dagonco.sorteo.navidad.api.request.GetSummaryRequest
import io.github.dagonco.sorteo.navidad.api.request.GetSummaryResponse

class SorteoNavidadApiClient(
    private val apiClient: ApiClient,
) {

    suspend fun getStatus(): Either<ApiError, GetStatusResponse> =
        apiClient.sendRequest(GetStatusRequest())

    suspend fun getSummary(): Either<ApiError, GetSummaryResponse> =
        apiClient.sendRequest(GetSummaryRequest())

    suspend fun getResult(number: Int): Either<ApiError, GetResultResponse> =
        apiClient.sendRequest(GetResultRequest(number))
}
