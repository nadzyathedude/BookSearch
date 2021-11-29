package com.example.booksearch.ui.base

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import moxy.MvpView
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BasePresenter<View : MvpView> : MvpPresenter<View>(), KoinComponent {

    protected open val compositeDisposable = CompositeDisposable()
    val router: Router by inject()
}
