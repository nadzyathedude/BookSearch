package com.example.booksearch.ui.search

import androidx.appcompat.widget.SearchView
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd
import moxy.viewstate.strategy.alias.AddToEndSingle

interface SearchView : MvpView {

    @AddToEnd
    fun showLoadingState()

    @AddToEndSingle
    fun showEmptyState()

    @AddToEndSingle
    fun showContentState()

    @AddToEndSingle
    fun bindBookListItems(newItems: List<GoogleBookItem>)

    @AddToEndSingle
    fun showToastOnError()

    @AddToEndSingle
    fun hideKeyboard()

   // @AddToEndSingle
    //fun setSearchViewListener(searchView: SearchView)
}
