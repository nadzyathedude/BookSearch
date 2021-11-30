package com.example.booksearch.ui.search

import com.example.booksearch.ui.search.adapter.GoogleBookItem
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd

interface SearchView : MvpView {
    @AddToEnd
    fun showProgressBar()

    @AddToEnd
    fun hideProgressBar()

    @AddToEnd
    fun hideWelcomePhrase()

    @AddToEnd
    fun bindBookListItems(newItems: List<GoogleBookItem>)
}
