package com.example.booksearch.ui.search

import com.example.booksearch.ui.base.BaseView

interface SearchView : BaseView {

    fun loadBooks(query: String)

    fun fetchData(query: String)

    fun navigateToFiltersScreen()
}
