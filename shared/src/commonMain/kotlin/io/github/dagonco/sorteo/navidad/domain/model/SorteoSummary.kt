package io.github.dagonco.sorteo.navidad.domain.model
import kotlinx.serialization.Serializable

@Serializable
data class SorteoSummary(
    val firstPrizeNumber: Int,
    val secondPrizeNumber: Int,
    val thirdPrizeNumber: Int,
    val fourth1PrizeNumber: Int,
    val fourth2PrizeNumber: Int,
    val fifth1PrizeNumber: Int,
    val fifth2PrizeNumber: Int,
    val fifth3PrizeNumber: Int,
    val fifth4PrizeNumber: Int,
    val fifth5PrizeNumber: Int,
    val fifth6PrizeNumber: Int,
    val fifth7PrizeNumber: Int,
    val fifth8PrizeNumber: Int,
    val timestamp: Int,
)
