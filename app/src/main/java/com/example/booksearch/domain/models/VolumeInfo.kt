package com.example.booksearch.domain.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    @SerializedName("title")
    @Expose
    val title: String?,
    @SerializedName("authors")
    @Expose
    val authors: List<String>?,
    @SerializedName("publishedDate")
    @Expose
    val publishedDate: String?,
    @SerializedName("pageCount")
    @Expose
    val pageCount: Int?,
    @SerializedName("printType")
    @Expose
    val printType: String?,
    @SerializedName("maturityRating")
    @Expose
    val maturityRating: String?,
    @SerializedName("allowAnonLogging")
    @Expose
    val allowAnonLogging: Boolean?,
    @SerializedName("contentVersion")
    @Expose
    val contentVersion: String?,
    @SerializedName("language")
    @Expose
    val language: String?,
    @SerializedName("previewLink")
    @Expose
    val previewLink: String?,
    @SerializedName("infoLink")
    @Expose
    val infoLink: String?,
    @SerializedName("canonicalVolumeLink")
    @Expose
    val canonicalVolumeLink: String?,
    @SerializedName("description")
    @Expose
    val description: String?,
    @SerializedName("categories")
    @Expose
    val categories: List<String>?,
    @SerializedName("averageRating")
    @Expose
    val averageRating: Double?,
    @SerializedName("ratingsCount")
    @Expose
    val ratingsCount: Int?,
    @SerializedName("imageLinks")
    @Expose
    val imageLinks: ImageLinks?,
    @SerializedName("subtitle")
    @Expose
    val subtitle: String?,
    @SerializedName("publisher")
    @Expose
    val publisher: String?
)
