package com.example.booksearch.ui.filter

import android.os.Bundle
import android.view.*
import com.example.booksearch.R
import com.example.booksearch.databinding.FFiltersBinding
import com.example.booksearch.ui.filter.adapter.FilterAdapter
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.filter.adapter.FilterItem
import moxy.MvpAppCompatFragment

class FilterFragment : MvpAppCompatFragment(), FilterView {

    private val binding by lazy { FFiltersBinding.inflate(layoutInflater) }
    private val filtersAdapter by lazy { FilterAdapter() }
    var filterParameter: FilterEnum? = FilterEnum.ALL

    var filterList =
        listOf(
            FilterItem(getString(R.string.search_everything), FilterEnum.ALL),
            FilterItem(getString(R.string.search_by_author), FilterEnum.AUTHOR),
            FilterItem(getString(R.string.search_by_title), FilterEnum.TITLE),
            FilterItem(getString(R.string.searcg_by_genre), FilterEnum.SUBJECT),
            FilterItem(getString(R.string.search_by_publisher), FilterEnum.PUBLISHER)
        )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding.filtersRecyclerView.adapter = filtersAdapter
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filtersAdapter.setItems(filterList)
    }

    override fun onFilterChoose(filter: FilterEnum) {
        getChosenFilterPosition()
    }

    override fun getChosenFilterPosition(): Int? {
        val filterItem =
            filterList.find { it.parameter == filterParameter }
        var index = filterList.indexOf(filterItem)
        return if (index != -1) index else null
    }
}
