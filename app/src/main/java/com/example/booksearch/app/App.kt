package com.example.booksearch.app

import android.app.Application
import com.example.booksearch.data.module.*
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
                    uiModule,
                    domainModule,
                    preferencesModule
                )
            )
        }
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}
