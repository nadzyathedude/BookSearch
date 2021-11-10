package com.example.booksearch.ui.search

import com.arellomobile.mvp.MvpView
import com.example.booksearch.ui.base.BaseView
import com.example.booksearch.ui.filter.adapter.FilterEnum

interface SearchView : BaseView {

    fun loadBooks(query: String)

    fun onFilterChoose(filter : FilterEnum)

    fun getChosenFilterPosition() : Int?

    fun fetchData(query: String)

}