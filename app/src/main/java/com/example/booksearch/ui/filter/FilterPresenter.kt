package com.example.booksearch.ui.filter

import com.example.booksearch.R
import com.example.booksearch.ui.base.BasePresenter
import com.example.booksearch.ui.base.Screens
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.filter.adapter.FilterItem
import moxy.InjectViewState

@InjectViewState
class FilterPresenter : BasePresenter<FilterView>() {

    val RESULT_KEY = "1"
    var chosenFilter: FilterEnum = FilterEnum.ALL
    private var filterList =
        listOf(
            FilterItem(R.string.search_everything, FilterEnum.ALL, true),
            FilterItem(R.string.search_by_author, FilterEnum.AUTHOR, false),
            FilterItem(R.string.search_by_title, FilterEnum.TITLE, false),
            FilterItem(R.string.searcg_by_genre, FilterEnum.SUBJECT, false),
            FilterItem(R.string.search_by_publisher, FilterEnum.PUBLISHER, false)
        )

    private fun initData() {
        viewState.setFilters(filterList)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        initData()
    }

    fun onFilterClick(param: FilterItem) {
        if (chosenFilter != param.parameter) {
            chosenFilter = param.parameter
            setChecked(chosenFilter)
            viewState.updateFiltersList(filterList)
            router.sendResult(RESULT_KEY, chosenFilter.key)
            navigateToSearchScreen()
        }
    }
    fun onBackClick() {
        navigateToSearchScreen()
    }

    private fun navigateToSearchScreen() {

        router.backTo(Screens.Search(RESULT_KEY))
    }

    private fun setChecked(item: FilterEnum) {
        filterList.forEach { it.isSelected = false }
        filterList.find { it.parameter == item }?.isSelected = true
    }
}
