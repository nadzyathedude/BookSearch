package com.example.booksearch.domain.interactor

import com.example.booksearch.data.storage.FilterPreferences
import com.example.booksearch.domain.interactor.FilterInteractor

class FilterInteractorImpl(private val filterPreferences: FilterPreferences) : FilterInteractor {

    override fun setFilterParameter(filter: String) = filterPreferences.set(filter)
    override fun getFilterParameter() = filterPreferences.get()
}
