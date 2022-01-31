package com.example.booksearch.data.repository

import com.example.booksearch.domain.repository.GoogleBooksRepository
import com.example.booksearch.data.service.GoogleBooksApi
import com.example.booksearch.domain.models.BooksSearchResponse
import io.reactivex.rxjava3.core.Single

class GoogleBooksRepositoryImpl(private val api: GoogleBooksApi) : GoogleBooksRepository {
    override fun searchBooks(query: String): Single<BooksSearchResponse> {
        return api.searchBooks(query)
    }
}
