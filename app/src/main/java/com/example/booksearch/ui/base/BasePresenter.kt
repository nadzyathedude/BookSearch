package com.example.booksearch.ui.base

import androidx.lifecycle.MutableLiveData
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import moxy.MvpView

open class BasePresenter(val router: Router) : MvpPresenter<MvpView>() {

    val isLoading = MutableLiveData(false)
    protected val compositeDisposable = CompositeDisposable()
}
