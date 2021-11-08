package com.example.booksearch.domain.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookItemResponse(
    @SerializedName("kind")
    @Expose
    val kind: String?,
    @SerializedName("id")
    @Expose
    val id: String?,
    @SerializedName("etag")
    @Expose
    val etag: String?,
    @SerializedName("selfLink")
    @Expose
    val selfLink: String?,
    @SerializedName("volumeInfo")
    @Expose
    val volumeInfo: VolumeInfo?
)