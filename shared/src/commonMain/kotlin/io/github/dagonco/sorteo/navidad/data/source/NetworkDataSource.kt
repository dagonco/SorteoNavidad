package io.github.dagonco.sorteo.navidad.data.source

import io.github.dagonco.sorteo.commons.Either
import io.github.dagonco.sorteo.core.domain.ApiError
import io.github.dagonco.sorteo.navidad.api.SorteoNavidadApiClient
import io.github.dagonco.sorteo.navidad.domain.mapper.toDomain
import io.github.dagonco.sorteo.navidad.domain.model.SorteoLastUpdated
import io.github.dagonco.sorteo.navidad.domain.model.SorteoNumberResult
import io.github.dagonco.sorteo.navidad.domain.model.SorteoStatus
import io.github.dagonco.sorteo.navidad.domain.model.SorteoSummary

open class NetworkDataSource(
    private val apiClient: SorteoNavidadApiClient,
) {

    open suspend fun getStatus(): Either<ApiError, SorteoStatus> =
        apiClient
            .getStatus()
            .map { it.toDomain() }

    suspend fun getSummary(): Either<ApiError, SorteoSummary> =
        apiClient
            .getSummary()
            .map { it.toDomain() }

    suspend fun getResult(number: Int): Either<ApiError, SorteoNumberResult> =
        apiClient
            .getResult(number)
            .map { it.toDomain() }
}
