package com.example.booksearch.ui.filter

import com.example.booksearch.R
import com.example.booksearch.ui.base.BasePresenter
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.filter.adapter.FilterItem
import moxy.InjectViewState

@InjectViewState
class FilterPresenter : BasePresenter<FilterView>() {
    private var filterList =
    listOf(
    FilterItem(R.string.search_everything, FilterEnum.ALL),
    FilterItem(R.string.search_by_author, FilterEnum.AUTHOR),
    FilterItem(R.string.search_by_title, FilterEnum.TITLE),
    FilterItem(R.string.searcg_by_genre, FilterEnum.SUBJECT),
    FilterItem(R.string.search_by_publisher, FilterEnum.PUBLISHER)
    )

    var filterParameter: FilterEnum? = FilterEnum.ALL

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setFilters(filterList)
    }

    fun getChosenFilterPosition(): Int? {
        val filterItem =
            filterList.find { it.parameter == filterParameter }
        val index = filterList.indexOf(filterItem)
        return if (index != -1) index else null
    }
}
