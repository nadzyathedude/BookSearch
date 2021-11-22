package com.example.booksearch.ui.filter

import com.arellomobile.mvp.MvpView
import com.example.booksearch.ui.filter.adapter.FilterEnum

interface FilterView : MvpView {
    fun onFilterChoose(filter: FilterEnum)

    fun getChosenFilterPosition(): Int?
}
