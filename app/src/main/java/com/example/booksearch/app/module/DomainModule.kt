package com.example.booksearch.app.module

import com.example.booksearch.domain.interactor.FilterInteractor
import com.example.booksearch.domain.interactor.FilterInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    single<FilterInteractor> { FilterInteractorImpl(get()) }

}
