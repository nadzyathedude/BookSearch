package com.example.booksearch.ui.search

import com.arellomobile.mvp.MvpView
import com.example.booksearch.ui.base.BaseView
import com.example.booksearch.ui.filter.adapter.FilterEnum

interface SearchView : BaseView {

    fun loadBooks(query: String)

    fun fetchData(query: String)

    fun navigate()

}