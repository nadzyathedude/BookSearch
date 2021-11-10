package com.example.booksearch.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.booksearch.databinding.FFiltersBinding
import com.example.booksearch.ui.base.BaseFragment
import com.example.booksearch.ui.filter.adapter.FilterAdapter
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.search.SearchView

class FilterFragment : BaseFragment(), FilterView{
  @InjectPresenter lateinit var filterPresenter: FilterPresenter

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
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  override fun onFilterChoose(filter: FilterEnum) {
    TODO("Not yet implemented")
  }

  override fun getChosenFilterPosition(): Int? {
    TODO("Not yet implemented")
  }

}
