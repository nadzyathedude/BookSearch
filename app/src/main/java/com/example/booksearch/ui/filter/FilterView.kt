package com.example.booksearch.ui.filter

import com.example.booksearch.ui.filter.adapter.FilterItem
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface FilterView : MvpView {
    
    @AddToEndSingle
    fun setFilters(filterList: List<FilterItem>)
}
