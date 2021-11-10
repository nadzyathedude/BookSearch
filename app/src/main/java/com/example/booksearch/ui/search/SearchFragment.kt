package com.example.booksearch.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.booksearch.databinding.FFiltersBinding
import com.example.booksearch.databinding.FMainBinding
import com.example.booksearch.ui.base.BaseFragment
import com.example.booksearch.ui.search.adapter.GoogleBookSearchAdapter

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


    return binding.root
  }
}
