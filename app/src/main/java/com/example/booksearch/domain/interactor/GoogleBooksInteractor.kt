package com.example.booksearch.domain.interactor

import com.example.booksearch.domain.models.BookItemResponse
import io.reactivex.rxjava3.core.Single

interface GoogleBooksInteractor {

  fun searchBooks(query: String): Single<List<BookItemResponse>>
}
