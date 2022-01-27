package com.example.booksearch.domain.storage

interface FilterInteractor {
    fun setFilterParameter(filter: String)
    fun getFilterParameter(): String?
}
