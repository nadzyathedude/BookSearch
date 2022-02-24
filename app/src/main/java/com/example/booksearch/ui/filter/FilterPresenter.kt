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
    private var filterList =
        listOf(
            FilterItem(R.string.search_everything, FilterEnum.ALL, true),
            FilterItem(R.string.search_by_author, FilterEnum.AUTHOR, false),
            FilterItem(R.string.search_by_title, FilterEnum.TITLE, false),
            FilterItem(R.string.searcg_by_genre, FilterEnum.SUBJECT, false),
            FilterItem(R.string.search_by_publisher, FilterEnum.PUBLISHER, false)
        )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        initData()
    }

    private fun initData() {
        // val currentFilter = filterInteractor.getFilterParameter()?.let { FilterEnum.valueOf(it) }
        // currentFilter?.let { setChecked(it) }
        viewState.setFilters(filterList)
    }

    fun onFilterClick(param: FilterItem) {
        setChecked(param.parameter)
        // filterInteractor.setFilterParameter(param.parameter.name)
        viewState.updateFiltersList(filterList)
        router.sendResult(RESULT_KEY, param.parameter.key)
    }

    fun onBackClick() {
        navigateToSearchScreen()
    }

    private fun navigateToSearchScreen() {

        router.backTo(Screens.Search(RESULT_KEY))
        // router.backTo(Screens.Search())
    }

    private fun setChecked(item: FilterEnum) {
        filterList.forEach { it.isSelected = false }
        filterList.find { it.parameter == item }?.isSelected = true
    }
}
