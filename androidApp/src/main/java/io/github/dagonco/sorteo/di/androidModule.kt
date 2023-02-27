package io.github.dagonco.sorteo.di

import android.app.Application
import io.github.dagonco.sorteo.navidad.di.sharedModule
import io.github.dagonco.sorteo.navidad.getDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin(application: Application) {
    startKoin {
        androidContext(application)
        modules(androidModule + sharedModule)
    }
}

internal val androidModule = module {
    factory { getDataStore(get()) }
}