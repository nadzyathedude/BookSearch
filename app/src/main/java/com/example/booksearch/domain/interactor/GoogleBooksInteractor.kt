package com.example.booksearch.domain.interactor

import com.example.booksearch.domain.models.BookItemResponse
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import io.reactivex.rxjava3.core.Single

interface GoogleBooksInteractor {

  fun searchBooks(query: String): Single<List<GoogleBookItem>>
}
