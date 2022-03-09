package com.example.booksearch.ui.base

import com.example.booksearch.ui.filter.FilterFragment
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.search.SearchFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun Search(RESULT_KEY: String) = FragmentScreen { SearchFragment() }
    fun Filter(filterParameter: FilterEnum) =
        FragmentScreen { FilterFragment.newInstance(filterParameter) }
}
