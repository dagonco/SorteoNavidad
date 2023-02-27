package io.github.dagonco.sorteo.navidad.domain.mapper

import io.github.dagonco.sorteo.navidad.api.request.GetResultResponse
import io.github.dagonco.sorteo.navidad.api.request.GetStatusResponse
import io.github.dagonco.sorteo.navidad.api.request.GetSummaryResponse
import io.github.dagonco.sorteo.navidad.domain.model.SorteoNumberResult
import io.github.dagonco.sorteo.navidad.domain.model.SorteoStatus
import io.github.dagonco.sorteo.navidad.domain.model.SorteoSummary

fun GetResultResponse.toDomain(): SorteoNumberResult =
    SorteoNumberResult(
        number = numero,
        prize = premio,
    ).apply {
        this.timestamp = this@toDomain.timestamp
    }

fun GetStatusResponse.toDomain(): SorteoStatus = this.status.toSorteoStatus()

fun SorteoStatus.toData(): Int = when (this) {
    SorteoStatus.NotStarted -> 0
    SorteoStatus.Started -> 1
    SorteoStatus.Finished.TentativeResults -> 2
    SorteoStatus.Finished.OfficialResults -> 3
    SorteoStatus.Finished.OfficialResults -> 4
}

fun Int.toSorteoStatus(): SorteoStatus = when (this) {
    0 -> SorteoStatus.NotStarted
    1 -> SorteoStatus.Started
    2 -> SorteoStatus.Finished.TentativeResults
    3 -> SorteoStatus.Finished.OfficialResults
    4 -> SorteoStatus.Finished.OfficialResults
    else -> SorteoStatus.NotStarted
}


fun GetSummaryResponse.toDomain(): SorteoSummary = SorteoSummary(
    firstPrizeNumber = numero1,
    secondPrizeNumber = numero2,
    thirdPrizeNumber = numero3,
    fourth1PrizeNumber = numero4,
    fourth2PrizeNumber = numero5,
    fifth1PrizeNumber = numero6,
    fifth2PrizeNumber = numero7,
    fifth3PrizeNumber = numero8,
    fifth4PrizeNumber = numero9,
    fifth5PrizeNumber = numero10,
    fifth6PrizeNumber = numero11,
    fifth7PrizeNumber = numero12,
    fifth8PrizeNumber = numero13,
    timestamp = timestamp,
)