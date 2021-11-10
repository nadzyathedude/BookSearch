package com.example.booksearch.ui.filter

import com.example.booksearch.ui.filter.adapter.FilterEnum

interface FilterView {
    fun onFilterChoose(filter : FilterEnum)

    fun getChosenFilterPosition() : Int?
}