package com.example.booksearch.ui.base

import androidx.lifecycle.MutableLiveData
import com.arellomobile.mvp.MvpPresenter
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BasePresenter(val router: Router) : MvpPresenter<BaseView>() {

    val isLoading = MutableLiveData(false)
    protected val compositeDisposable = CompositeDisposable()
}
