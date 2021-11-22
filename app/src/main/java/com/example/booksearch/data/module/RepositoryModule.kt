package com.example.booksearch.data.module

import com.example.booksearch.domain.interactor.GoogleBooksInteractor
import com.example.booksearch.domain.interactor.GoogleBooksInteractorImpl
import com.example.booksearch.domain.repository.GoogleBooksService
import com.example.booksearch.domain.repository.GoogleBooksServiceImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GoogleBooksService> { GoogleBooksServiceImpl(get()) }
    single<GoogleBooksInteractor> { GoogleBooksInteractorImpl(get()) }
}