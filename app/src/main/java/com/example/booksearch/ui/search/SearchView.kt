package com.example.booksearch.ui.search

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd

interface SearchView : MvpView {
    @AddToEnd
    fun showProgressBar()

    @AddToEnd
    fun hideProgressBar()

    @AddToEnd
    fun hideWelcomePhrase()
}
