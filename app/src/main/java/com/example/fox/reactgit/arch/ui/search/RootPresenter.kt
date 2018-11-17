package com.example.fox.reactgit.arch.ui.search

import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.base.navigation.RootNavigation
import com.example.fox.reactgit.arch.ui.base.navigation.RootRouter
import com.example.fox.reactgit.utils.enums.Screens.*

class RootPresenter(private val router: RootRouter) : BasePresenter<IRootView>(),RootNavigation {
    override fun init() {
        getView().init()
    }

    override fun openSearchFragment() {
        router.openSearchFragment()
    }

    override fun closeSearchFragment() {
        router.closeSearchFragment()
    }

    override fun openFavouriteFragment() {
        router.openFavouriteFragment()
    }

    override fun closeFavouriteFragment() {
        router.closeFavouriteFragment()
    }

    override fun openDetailFragment() {
        router.openDetailFragment()
    }

    override fun closeDetailFragment() {
        router.closeDetailFragment()
    }
}