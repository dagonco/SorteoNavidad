package io.github.dagonco.sorteo.navidad

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.github.dagonco.sorteo.navidad.data.source.datastore.dataStoreFileName
import io.github.dagonco.sorteo.navidad.data.source.datastore.getDataStore

fun getDataStore(context: Context): DataStore<Preferences> = getDataStore(
    producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
)
