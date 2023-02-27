package io.github.dagonco.sorteo.navidad.domain.model
import kotlinx.serialization.Serializable

@Serializable
sealed class SorteoStatus {

    object NotStarted : SorteoStatus()
    object Started : SorteoStatus()

    sealed class Finished : SorteoStatus() {
        object TentativeResults : Finished()
        object OfficialResults : Finished()
    }
}
