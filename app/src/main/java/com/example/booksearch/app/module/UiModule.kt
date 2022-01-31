package com.example.booksearch.app.module

import com.github.terrakok.cicerone.Cicerone
import org.koin.dsl.module

val uiModule = module {
    val router = Cicerone.create()
    single { router.getNavigatorHolder() }
    single { router.router }
}
