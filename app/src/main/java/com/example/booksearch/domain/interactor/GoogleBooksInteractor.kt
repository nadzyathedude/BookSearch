package com.example.booksearch.domain.interactor

import com.example.booksearch.ui.search.adapter.GoogleBookItem
import io.reactivex.rxjava3.core.Maybe

interface GoogleBooksInteractor {

    fun searchBooks(query: String): Maybe<List<GoogleBookItem>>

}
