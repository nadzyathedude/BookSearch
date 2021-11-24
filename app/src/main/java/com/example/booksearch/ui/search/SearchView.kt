package com.example.booksearch.ui.search

import moxy.MvpView

interface SearchView : MvpView {

    fun loadBooks(query: String)

    fun fetchData(query: String)

    fun navigateToFiltersScreen()
}
