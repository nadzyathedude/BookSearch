package com.example.booksearch.ui.search

import androidx.lifecycle.MutableLiveData
import com.arellomobile.mvp.InjectViewState
import com.example.booksearch.ui.base.BasePresenter
import com.example.booksearch.ui.base.Screens
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.filter.adapter.FilterItem
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import com.github.terrakok.cicerone.Router

@InjectViewState
class SearchPresenter(router: Router) : BasePresenter(router), SearchView {


  var filterParameter: FilterEnum? = FilterEnum.ALL
  var currentQuery = ""
  private val booksListLiveData: MutableLiveData<List<GoogleBookItem>> = MutableLiveData()

  override fun loadBooks(query: String) {
    TODO("Not yet implemented")
  }


  override fun fetchData(query: String) {

    currentQuery = query

    if (query.isBlank()) {
      booksListLiveData.value = emptyList()
      return
    }
    val preparedQuery = filterParameter?.key + ":" + query
    loadBooks(preparedQuery)
  }

  override fun navigate() {
    router.navigateTo(Screens.Filter())
  }
}
