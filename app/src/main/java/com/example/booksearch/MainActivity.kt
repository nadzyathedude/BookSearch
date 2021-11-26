package com.example.booksearch

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import com.example.booksearch.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.MvpView

class MainActivity : MvpAppCompatActivity(), MvpView {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(binding.mainActivityToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}
