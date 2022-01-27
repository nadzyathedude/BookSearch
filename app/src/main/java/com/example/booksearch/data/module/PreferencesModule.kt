package com.example.booksearch.data.module

import androidx.preference.PreferenceManager
import com.example.booksearch.data.storage.FilterPreferences
import com.example.booksearch.data.storage.FilterPreferencesRepository
import com.example.booksearch.domain.storage.FilterInteractor
import org.koin.core.module.Module
import org.koin.dsl.module

val preferencesModule = module {
    single { FilterPreferences(get()) }
    single<FilterInteractor> { FilterPreferencesRepository(get()) }
    provideSharedPreferences()
}

fun Module.provideSharedPreferences() {
    single { PreferenceManager.getDefaultSharedPreferences(get()) }
}
