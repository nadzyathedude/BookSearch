package com.example.booksearch.domain.storage

import com.example.booksearch.data.storage.FilterPreferences

class FilterInteractorImpl(private val filterPreferences: FilterPreferences) : FilterInteractor {

    override fun setFilterParameter(filter: String) = filterPreferences.set(filter)
    override fun getFilterParameter() = filterPreferences.get()
}
