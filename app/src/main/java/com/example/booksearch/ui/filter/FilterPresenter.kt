package com.example.booksearch.ui.filter

import com.example.booksearch.R
import com.example.booksearch.ui.base.BasePresenter
import com.example.booksearch.ui.base.Screens
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.filter.adapter.FilterItem
import moxy.InjectViewState

@InjectViewState
class FilterPresenter : BasePresenter<FilterView>() {
    private var filterList =
        listOf(
            FilterItem(R.string.search_everything, FilterEnum.ALL, false),
            FilterItem(R.string.search_by_author, FilterEnum.AUTHOR, false),
            FilterItem(R.string.search_by_title, FilterEnum.TITLE, false),
            FilterItem(R.string.searcg_by_genre, FilterEnum.SUBJECT, false),
            FilterItem(R.string.search_by_publisher, FilterEnum.PUBLISHER, false)
        )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setFilters(filterList)
    }

    private fun setChecked(item: FilterEnum) {
        filterList.forEach { it.isSelected = false }
        filterList.find { it.parameter == item }?.isSelected = true
    }

    fun onFilterClick(param: FilterItem) {
        setChecked(param.parameter)
        viewState.updateFiltersList(filterList)
    }

    fun onBackClick() {
        navigateToSearchScreen()
    }

    private fun navigateToSearchScreen() {
        router.navigateTo(Screens.Search())
    }
}
