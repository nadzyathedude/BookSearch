package com.example.booksearch.ui.filter

import android.os.Bundle
import android.view.* // ktlint-disable no-wildcard-imports
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.booksearch.databinding.FFiltersBinding
import com.example.booksearch.ui.base.BaseFragment
import com.example.booksearch.ui.filter.adapter.FilterAdapter
import com.example.booksearch.ui.filter.adapter.FilterEnum

class FilterFragment : BaseFragment(), FilterView {
    @InjectPresenter
    lateinit var filterPresenter: FilterPresenter

    private val binding by lazy { FFiltersBinding.inflate(layoutInflater) }
    private val filtersAdapter by lazy { FilterAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding.recyclerViewFilters.adapter = filtersAdapter
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filtersAdapter.setItems(filterPresenter.filterList)
    }

    override fun onFilterChoose(filter: FilterEnum) {
        filterPresenter.getChosenFilterPosition()
    }

    override fun getChosenFilterPosition(): Int? {
        TODO("Not yet implemented")
    }
}
