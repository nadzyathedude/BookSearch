package com.example.booksearch.data.module

import com.example.booksearch.domain.storage.FilterInteractor
import com.example.booksearch.domain.storage.FilterInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    single<FilterInteractor> { FilterInteractorImpl(get()) }
}
