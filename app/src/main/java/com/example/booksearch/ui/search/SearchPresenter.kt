package com.example.booksearch.ui.search

import androidx.lifecycle.MutableLiveData
import com.arellomobile.mvp.InjectViewState
import com.example.booksearch.ui.base.BasePresenter
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.filter.adapter.FilterItem
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import com.github.terrakok.cicerone.Router

class SearchPresenter(router: Router) : BasePresenter(router), SearchView {
  @InjectViewState
  companion object {
    val filterList =
        listOf(
            FilterItem("Поиск по всему", FilterEnum.ALL),
            FilterItem("Поиск по автору", FilterEnum.AUTHOR),
            FilterItem("Поиск по названию", FilterEnum.TITLE),
            FilterItem("Поиск по жанру", FilterEnum.SUBJECT),
            FilterItem("Поиск по издателю", FilterEnum.PUBLISHER))
  }

  var filterParameter: FilterEnum? = FilterEnum.ALL
  var currentQuery = ""
  private val booksListLiveData: MutableLiveData<List<GoogleBookItem>> = MutableLiveData()

  override fun loadBooks(query: String) {

  }

  override fun onFilterChoose(filter: FilterEnum) {
    filterParameter = filter
  }

  override fun getChosenFilterPosition(): Int? {
    val filterItem = filterList.find { it.parameter == filterParameter }
    var index = filterList.indexOf(filterItem)
    return if (index != -1) index else null
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
}
