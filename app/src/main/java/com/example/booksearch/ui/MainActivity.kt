package com.example.booksearch.ui

import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.booksearch.R
import com.example.booksearch.app.App
import com.example.booksearch.databinding.ActivityMainBinding
import com.example.booksearch.ui.base.BaseView
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : MvpAppCompatActivity(), BaseView {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val navigator = AppNavigator(this, R.id.container)

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }
}