package io.github.dagonco.sorteo.navidad.api.request

import kotlinx.serialization.Serializable


class GetResultRequest(number: Int) : SorteoNavidadApiRequest<GetResultResponse>() {
    override val queryParams: Map<String, String> =
        mapOf("n" to "$number")
}

@Serializable
data class GetResultResponse(
    val numero: Int,
    val premio: Int,
    val timestamp: Int,
)
