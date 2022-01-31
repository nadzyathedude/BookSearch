package com.example.booksearch.ui

import com.example.booksearch.ui.base.BasePresenter
import com.example.booksearch.ui.base.Screens
import moxy.InjectViewState

@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.Search())
    }
}
