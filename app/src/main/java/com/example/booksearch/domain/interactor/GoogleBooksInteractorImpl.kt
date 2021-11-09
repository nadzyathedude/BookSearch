package com.example.booksearch.domain.interactor

import com.example.booksearch.domain.models.BookItemResponse
import com.example.booksearch.domain.models.BooksSearchResponse
import com.example.booksearch.domain.repository.GoogleBooksService
import io.reactivex.rxjava3.core.Single

class GoogleBooksInteractorImpl(private val googleBooksService: GoogleBooksService) : GoogleBooksInteractor {
    override fun searchBooks(query: String): Single<List<BookItemResponse>> {
        TODO("Not yet implemented")
    }

}
