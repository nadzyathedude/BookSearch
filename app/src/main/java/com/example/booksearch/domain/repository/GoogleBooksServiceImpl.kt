package com.example.booksearch.domain.repository

import com.example.booksearch.domain.GoogleBooksApi
import com.example.booksearch.domain.models.BooksSearchResponse
import io.reactivex.rxjava3.core.Single

class GoogleBooksServiceImpl(private val api: GoogleBooksApi) : GoogleBooksService {
    override fun searchBooks(query: String): Single<BooksSearchResponse> {
        return api.searchBooks(query)
    }
}
