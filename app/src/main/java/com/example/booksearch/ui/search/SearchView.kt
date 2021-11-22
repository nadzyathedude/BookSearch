package com.example.booksearch.ui.search

import com.arellomobile.mvp.MvpView

interface SearchView : MvpView {

    fun loadBooks(query: String)

    fun fetchData(query: String)

    fun navigateToFiltersScreen()
}
