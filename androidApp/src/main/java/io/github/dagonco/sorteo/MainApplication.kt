package io.github.dagonco.sorteo

import android.app.Application
import io.github.dagonco.sorteo.di.initKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(this)
    }
}