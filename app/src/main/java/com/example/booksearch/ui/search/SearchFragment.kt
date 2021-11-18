package com.example.booksearch.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.booksearch.R
import com.example.booksearch.databinding.FMainBinding
import com.example.booksearch.ui.base.BaseFragment
import com.example.booksearch.ui.search.adapter.GoogleBookSearchAdapter
import com.example.booksearch.utils.safeLet

class SearchFragment : BaseFragment() {
  @InjectPresenter lateinit var searchPresenter: SearchPresenter
  private val googleBookSearchAdapter by lazy { GoogleBookSearchAdapter() }
  private val binding by lazy { FMainBinding.inflate(layoutInflater) }

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
    with(binding) {
      fMainRecyclerViewBooks.adapter = googleBookSearchAdapter
      addItemDecoration(this.fMainRecyclerViewBooks)
      return binding.root
    }
  }
  private fun addItemDecoration(recyclerView: RecyclerView) {
    val orientation = (recyclerView.layoutManager as? LinearLayoutManager)?.orientation
    val divider = AppCompatResources.getDrawable(recyclerView.context, R.drawable.divider)

    safeLet(orientation, divider) { orientation, divider ->
      val itemDecoration = DividerItemDecoration(recyclerView.context, orientation)
      itemDecoration.setDrawable(divider)
      recyclerView.addItemDecoration(itemDecoration)
    }
  }
}
