package com.example.booksearch.ui.filter

import com.example.booksearch.ui.filter.adapter.FilterItem
import moxy.MvpView
import java.util.logging.Filter

interface FilterView : MvpView {

    fun setFilters(filterList: List<FilterItem>)
}
