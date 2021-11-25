package com.example.booksearch.app

import android.app.Application
import com.example.booksearch.data.module.networkModule
import com.example.booksearch.data.module.repositoryModule
import com.example.booksearch.data.module.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    uiModule
                )
            )
        }
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}
