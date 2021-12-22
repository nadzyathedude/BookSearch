package com.example.booksearch.ui.search

import com.example.booksearch.ui.search.adapter.GoogleBookItem
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd
import moxy.viewstate.strategy.alias.AddToEndSingle

interface SearchView : MvpView {
    @AddToEndSingle
    fun showProgressBar()

    @AddToEndSingle
    fun hideProgressBar()

    @AddToEndSingle
    fun showEmptyState()

    @AddToEnd
    fun showBooks()

    @AddToEnd
    fun bindBookListItems(newItems: List<GoogleBookItem>)
}
