package com.example.booksearch.ui.filter

import com.example.booksearch.ui.filter.adapter.FilterEnum
import moxy.MvpView

interface FilterView : MvpView {
    fun onFilterChoose(filter: FilterEnum)

    fun getChosenFilterPosition(): Int?
}
