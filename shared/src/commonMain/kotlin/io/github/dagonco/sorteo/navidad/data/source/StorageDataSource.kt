package io.github.dagonco.sorteo.navidad.data.source

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import io.github.dagonco.sorteo.core.di.json
import io.github.dagonco.sorteo.navidad.domain.mapper.toData
import io.github.dagonco.sorteo.navidad.domain.mapper.toSorteoStatus
import io.github.dagonco.sorteo.navidad.domain.model.SorteoLastUpdated
import io.github.dagonco.sorteo.navidad.domain.model.SorteoStatus
import io.github.dagonco.sorteo.navidad.domain.model.SorteoSummary
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

open class StorageDataSource(
    private val dataStore: DataStore<Preferences>,
) {

    private val lastUpdatedKey = stringPreferencesKey("sorteo_navidad_last_updated_key")
    private val statusKey = intPreferencesKey("sorteo_navidad_status_key")
    private val summaryKey = stringPreferencesKey("sorteo_navidad_summary_key")

    fun getLastUpdated(): Flow<SorteoLastUpdated> =
        dataStore.data
            .map { preferences -> preferences[lastUpdatedKey] }
            .filterNotNull()
            .distinctUntilChanged()
            .map { json.decodeFromString(it) }


    fun getStatus(): Flow<SorteoStatus> =
        dataStore.data
            .map { preferences -> preferences[statusKey] }
            .filterNotNull()
            .distinctUntilChanged()
            .map { it.toSorteoStatus() }


    fun getSummary(): Flow<SorteoSummary> =
        dataStore.data
            .map { preferences -> preferences[summaryKey] }
            .filterNotNull()
            .distinctUntilChanged()
            .map { json.decodeFromString(it) }

    suspend fun setLastUpdated(lastUpdated: SorteoLastUpdated) =
        dataStore.edit { preferences ->
            preferences[lastUpdatedKey] = json.encodeToString(lastUpdated)
        }

    suspend fun setStatus(status: SorteoStatus): Preferences {
        return dataStore.edit { preferences ->
            preferences[statusKey] = status.toData()
        }
    }

    suspend fun setSummary(summary: SorteoSummary) =
        dataStore.edit { preferences ->
            preferences[summaryKey] = json.encodeToString(summary)
        }
}