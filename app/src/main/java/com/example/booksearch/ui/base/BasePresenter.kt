package com.example.booksearch.ui.base

import androidx.lifecycle.MutableLiveData
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import moxy.MvpView
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BasePresenter<View : MvpView> : MvpPresenter<View>(), KoinComponent {

    val isLoading = MutableLiveData(false)
    protected open val compositeDisposable = CompositeDisposable()
    val router: Router by inject()
}
