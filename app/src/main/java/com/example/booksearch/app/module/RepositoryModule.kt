package com.example.booksearch.app.module

import com.example.booksearch.domain.interactor.GoogleBooksInteractor
import com.example.booksearch.domain.interactor.GoogleBooksInteractorImpl
import com.example.booksearch.domain.repository.GoogleBooksRepository
import com.example.booksearch.data.repository.GoogleBooksRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GoogleBooksRepository> { GoogleBooksRepositoryImpl(get()) }
    single<GoogleBooksInteractor> { GoogleBooksInteractorImpl(get()) }
}
