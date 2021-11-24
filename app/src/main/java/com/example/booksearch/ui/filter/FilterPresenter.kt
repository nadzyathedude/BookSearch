package com.example.booksearch.ui.filter

import com.example.booksearch.ui.base.BasePresenter
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.filter.adapter.FilterItem
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState

@InjectViewState
class FilterPresenter(router: Router) : BasePresenter(router), FilterView {
    var filterList =
        listOf(
            FilterItem("Поиск по всему", FilterEnum.ALL),
            FilterItem("Поиск по автору", FilterEnum.AUTHOR),
            FilterItem("Поиск по названию", FilterEnum.TITLE),
            FilterItem("Поиск по жанру", FilterEnum.SUBJECT),
            FilterItem("Поиск по издателю", FilterEnum.PUBLISHER)
        )
    var filterParameter: FilterEnum? = FilterEnum.ALL

    override fun onFilterChoose(filter: FilterEnum) {
        filterParameter = filter
    }

    override fun getChosenFilterPosition(): Int? {
        val filterItem = filterList.find { it.parameter == filterParameter }
        var index = filterList.indexOf(filterItem)
        return if (index != -1) index else null
    }
}
