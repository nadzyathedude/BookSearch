package com.example.booksearch.ui.search

import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.booksearch.ui.base.BaseFragment


class SearchFragment : BaseFragment() {
    @InjectPresenter
    lateinit var searchPresenter: SearchPresenter

}