package com.example.booksearch.domain.interactor

import com.example.booksearch.domain.repository.GoogleBooksService
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import io.reactivex.rxjava3.core.Maybe

class GoogleBooksInteractorImpl(private val googleBooksService: GoogleBooksService) :
    GoogleBooksInteractor {
    override fun searchBooks(query: String): Maybe<List<GoogleBookItem>> {
        return googleBooksService.searchBooks(query).flatMapMaybe { booksResponse ->
            booksResponse.bookItemResponses?.map { bookItem ->
                GoogleBookItem(
                    bookItem.volumeInfo,
                )
            }?.let { Maybe.just(it) } ?: Maybe.empty()
        }
    }
}
