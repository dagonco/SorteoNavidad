package io.github.dagonco.sorteo.navidad.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SorteoNumberResult(
    val number: Int,
    val prize: Int,
) {
    var timestamp: Int = 0
    var bet: Int = 0
}
