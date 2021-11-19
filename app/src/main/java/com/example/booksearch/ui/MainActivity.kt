package com.example.booksearch.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.booksearch.R
import com.example.booksearch.app.App
import com.example.booksearch.databinding.ActivityMainBinding
import com.example.booksearch.ui.base.BaseView
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : MvpAppCompatActivity(), BaseView {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
    }
    override fun onResumeFragments() {
        super.onResumeFragments()
        App.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}
