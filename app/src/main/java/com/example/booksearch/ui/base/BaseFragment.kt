package com.example.booksearch.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.booksearch.utils.onDestroyNullable
import moxy.MvpAppCompatFragment
import moxy.MvpView

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: (
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ) -> VB
) : MvpAppCompatFragment(), MvpView {

    protected var binding by onDestroyNullable<VB>()

    //    abstract fun initAdapter()
//
//    abstract fun initOptionsMenu()
//
//    abstract fun setWelcomeTextVisible()
    abstract fun initViews()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initAdapter()
//        initOptionsMenu()
//        setWelcomeTextVisible()
        initViews()
    }
}
