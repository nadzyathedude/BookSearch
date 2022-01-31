package com.example.booksearch.data.storage

import com.example.booksearch.domain.interactor.FilterInteractor

class FilterPreferencesRepository(private val filterPreferences: FilterPreferences) :
    FilterInteractor {
    override fun setFilterParameter(filter: String) = filterPreferences.set(filter)
    override fun getFilterParameter() = filterPreferences.get()
}
