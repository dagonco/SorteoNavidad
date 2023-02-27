package io.github.dagonco.sorteo.navidad.data

import io.github.dagonco.sorteo.commons.Either
import io.github.dagonco.sorteo.commons.left
import io.github.dagonco.sorteo.commons.right
import io.github.dagonco.sorteo.core.domain.Error
import io.github.dagonco.sorteo.navidad.data.source.NetworkDataSource
import io.github.dagonco.sorteo.navidad.data.source.StorageDataSource
import io.github.dagonco.sorteo.navidad.domain.model.SorteoLastUpdated
import io.github.dagonco.sorteo.navidad.domain.model.SorteoNumberResult
import io.github.dagonco.sorteo.navidad.domain.model.SorteoStatus
import io.github.dagonco.sorteo.navidad.domain.model.SorteoSummary
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach

open class Repository(
    private val storageDataSource: StorageDataSource,
    private val networkDataSource: NetworkDataSource,
) {

    suspend fun refreshStatus() {
        networkDataSource.getStatus()
            .runSuspend { status ->
                storageDataSource.setStatus(status)
            }
    }

    fun getStatus(): Flow<SorteoStatus> {
        return storageDataSource.getStatus()
    }

    suspend fun refreshSummary() {
        networkDataSource.getSummary()
            .runSuspend { summary ->
                storageDataSource.setSummary(summary)
            }
    }

    fun getSummary(): Flow<SorteoSummary> {
        return storageDataSource.getSummary().onEach { sorteoSummary ->
            storageDataSource.setLastUpdated(SorteoLastUpdated(sorteoSummary.timestamp))
        }
    }

    suspend fun getResult(number: Int, bet: Int): Flow<Either<Error, SorteoNumberResult>> {
        return networkDataSource.getResult(number)
            .fold(
                left = { error -> flowOf(error.left()) },
                right = { numberResult ->
                    numberResult.bet = bet
                    flowOf(numberResult.right())
                },
            )
    }

    fun getLastUpdated(): Flow<SorteoLastUpdated> =
        storageDataSource.getLastUpdated()
}
