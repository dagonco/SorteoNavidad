package io.github.dagonco.sorteo.navidad.api.request

import kotlinx.serialization.Serializable


class GetStatusRequest : SorteoNavidadApiRequest<GetStatusResponse>() {
    override val queryParams: Map<String, String> =
        mapOf("s" to "1")
}

@Serializable
data class GetStatusResponse(
    val status: Int,
)
