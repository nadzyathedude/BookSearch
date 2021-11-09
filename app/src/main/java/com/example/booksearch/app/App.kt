package com.example.booksearch.app

import android.app.Application
import com.example.booksearch.app.module.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin {
          androidContext(this@App)
      modules(
        listOf(
            networkModule
        )
      )
    }
  }
}
