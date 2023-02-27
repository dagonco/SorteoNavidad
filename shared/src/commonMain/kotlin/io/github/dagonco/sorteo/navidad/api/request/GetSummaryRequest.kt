package io.github.dagonco.sorteo.navidad.api.request

import kotlinx.serialization.Serializable


class GetSummaryRequest : SorteoNavidadApiRequest<GetSummaryResponse>() {
    override val queryParams: Map<String, String> =
        mapOf("n" to "resumen")
}

@Serializable
data class GetSummaryResponse(
    val numero1: Int, // First price
    val numero2: Int, // Second price
    val numero3: Int, // Third price
    val numero4: Int, // Fourth price (1)
    val numero5: Int, // Fourth price (2)
    val numero6: Int, // Fifth price (1)
    val numero7: Int, // Fifth price (2)
    val numero8: Int, // Fifth price (3)
    val numero9: Int, // Fifth price (4)
    val numero10: Int, // Fifth price (5)
    val numero11: Int, // Fifth price (6)
    val numero12: Int, // Fifth price (7)
    val numero13: Int, // Fifth price (8)
    val timestamp: Int, // Fifth price (8)
)
