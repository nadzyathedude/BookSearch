package com.example.booksearch.ui.filter

import com.example.booksearch.ui.base.BaseView
import com.example.booksearch.ui.filter.adapter.FilterEnum

interface FilterView : BaseView {
    fun onFilterChoose(filter: FilterEnum)

    fun getChosenFilterPosition(): Int?
}
