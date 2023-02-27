package io.github.dagonco.sorteo.core.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.github.dagonco.sorteo.commons.Either
import io.github.dagonco.sorteo.core.di.json
import io.github.dagonco.sorteo.core.domain.StorageError
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

class DataStorage(
    private val dataStore: DataStore<Preferences>
) {

}