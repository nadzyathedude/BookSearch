package com.example.booksearch.domain.repository

import com.example.booksearch.domain.models.BooksSearchResponse
import io.reactivex.rxjava3.core.Single

interface GoogleBooksService {

  fun searchBooks(query: String): Single<BooksSearchResponse>
}
