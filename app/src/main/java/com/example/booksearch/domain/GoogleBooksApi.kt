package com.example.booksearch.domain

import com.example.booksearch.domain.models.BooksSearchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksApi {

    @GET("volumes")
    fun searchBooks(@Query("q") query: String? = null): Single<BooksSearchResponse>
}
