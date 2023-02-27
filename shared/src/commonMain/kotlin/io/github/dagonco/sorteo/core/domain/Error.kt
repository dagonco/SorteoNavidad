package io.github.dagonco.sorteo.core.domain

open class Error
data class ApiError(val message: String) : Error()
sealed class StorageError : Error(){
    object StoragePreferenceNotFound: StorageError()
    object StoragePreferenceParseError: StorageError()
}
