package com.example.booksearch.ui.filter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.booksearch.ui.base.BaseFragment

class FilterFragment : BaseFragment(){
    @InjectPresenter
    lateinit var filterPresenter : FilterPresenter
}