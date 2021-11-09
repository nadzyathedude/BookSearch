package com.example.booksearch.domain.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BooksSearchResponse(
    @SerializedName("kind")
    @Expose
    val kind: String?,
    @SerializedName("totalItems")
    @Expose
    val totalItems: Int?,
    @SerializedName("items")
    @Expose
    val bookItemResponses: List<BookItemResponse>?
)