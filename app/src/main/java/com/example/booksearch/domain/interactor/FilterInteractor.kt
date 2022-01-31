package com.example.booksearch.domain.interactor

interface FilterInteractor {
    fun setFilterParameter(filter: String)
    fun getFilterParameter(): String?
}
