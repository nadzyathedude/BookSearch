package com.example.booksearch.ui.base

import com.example.booksearch.ui.filter.FilterFragment
import com.example.booksearch.ui.search.SearchFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Search() = FragmentScreen { SearchFragment() }
    fun Filter() = FragmentScreen { FilterFragment() }
}