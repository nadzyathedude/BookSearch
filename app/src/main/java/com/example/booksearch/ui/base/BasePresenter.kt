package com.example.booksearch.ui.base

import com.arellomobile.mvp.MvpPresenter
import com.example.booksearch.ui.base.Screens.Search
import com.example.booksearch.ui.filter.FilterFragment
import com.example.booksearch.ui.search.SearchFragment
import ru.terrakok.cicerone.Router

open class BasePresenter(private val router: Router) : MvpPresenter<BaseView>() {

  fun onOpenSearch() {
    router.navigateTo(Search())
  }
  fun onOpenFilter() {
    router.navigateTo(Search())
  }
  fun onBackPressed() {
    router.exit()
  }
}


