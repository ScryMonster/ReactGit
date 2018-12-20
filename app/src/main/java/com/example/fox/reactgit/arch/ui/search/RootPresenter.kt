package com.example.fox.reactgit.arch.ui.search

import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.base.navigation.RootNavigation
import com.example.fox.reactgit.arch.ui.base.navigation.RootRouter
import com.example.fox.reactgit.di.scopes.RootScope
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.utils.enums.Screens.*

@RootScope
class RootPresenter(private val router: RootRouter) : BasePresenter<IRootView>(),RootNavigation {
    override fun init() {
        view?.init()
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

    override fun openDetailFragment(repositories: List<Repository>) {
        router.openDetailFragment(repositories)
    }

    override fun closeDetailFragment() {
        router.closeDetailFragment()
    }
}