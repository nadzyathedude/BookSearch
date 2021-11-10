package com.example.booksearch.domain.interactor

import com.example.booksearch.domain.models.BookItemResponse
import com.example.booksearch.domain.models.BooksSearchResponse
import com.example.booksearch.domain.repository.GoogleBooksService
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import io.reactivex.rxjava3.core.Single

class GoogleBooksInteractorImpl(private val googleBooksService: GoogleBooksService) :
    GoogleBooksInteractor {
    override fun searchBooks(query: String): Single<List<GoogleBookItem>> {
        return googleBooksService.searchBooks(query).flatMap{booksResponse->
            return@flatMap Single.just(
                booksResponse.bookItemResponses?.map{bookItem->
                    GoogleBookItem(
                        bookItem.volumeInfo?.title,
                        bookItem.volumeInfo?.imageLinks?.smallThumbnail,
                        bookItem.volumeInfo?.authors?.joinToString(separator = ", "))
                })
        }
    }
}
