package io.github.dagonco.sorteo.navidad.domain

import io.github.dagonco.sorteo.commons.Either
import io.github.dagonco.sorteo.core.domain.Error
import io.github.dagonco.sorteo.navidad.data.Repository
import io.github.dagonco.sorteo.navidad.domain.model.SorteoLastUpdated
import io.github.dagonco.sorteo.navidad.domain.model.SorteoNumberResult
import io.github.dagonco.sorteo.navidad.domain.model.SorteoStatus
import io.github.dagonco.sorteo.navidad.domain.model.SorteoSummary
import kotlinx.coroutines.flow.Flow

class RefreshStatus(private val repository: Repository) {
    suspend operator fun invoke() =
        repository.refreshStatus()
}

class GetStatus(private val repository: Repository) {
    operator fun invoke(): Flow<SorteoStatus> =
        repository.getStatus()
}

class RefreshSummary(private val repository: Repository) {
    suspend operator fun invoke() =
        repository.refreshSummary()
}

class GetSummary(private val repository: Repository) {
    operator fun invoke(): Flow<SorteoSummary> =
        repository.getSummary()
}

class GetResult(private val repository: Repository) {
    suspend operator fun invoke(number: Int, bet: Int): Flow<Either<Error, SorteoNumberResult>> =
        repository.getResult(number, bet)
}

class GetLastUpdated(private val repository: Repository) {
    operator fun invoke(): Flow<SorteoLastUpdated> =
        repository.getLastUpdated()
}