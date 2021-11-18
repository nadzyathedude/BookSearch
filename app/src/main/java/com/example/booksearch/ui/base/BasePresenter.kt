package com.example.booksearch.ui.base

import androidx.lifecycle.MutableLiveData
import com.arellomobile.mvp.MvpPresenter
import com.example.booksearch.ui.base.Screens.Search
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BasePresenter(val router: Router) : MvpPresenter<BaseView>() {

  val isLoading = MutableLiveData(false)
  protected val compositeDisposable = CompositeDisposable()


  fun onOpenSearch() {
    router.navigateTo(Search())
  }
  fun onOpenFilter() {
    router.navigateTo(Search())
  }
  fun onBackPressed() {
    router.exit()
  }
}
