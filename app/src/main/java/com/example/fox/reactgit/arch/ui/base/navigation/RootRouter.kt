package com.example.fox.reactgit.arch.ui.base.navigation

import com.example.fox.reactgit.utils.enums.Screens.*

class RootRouter(private val navigator: SuppFragmentNavigator) : RootNavigation {
    override fun openSearchFragment() {
        navigator.goTo(SEARCH)
    }

    override fun closeSearchFragment() {
        navigator.back()
    }

    override fun openFavouriteFragment() {
        navigator.goTo(FAVOURITE)
    }

    override fun closeFavouriteFragment() {
        navigator.back()
    }

    override fun openDetailFragment() {
        navigator.goTo(DETAIL)
    }

    override fun closeDetailFragment() {
        navigator.back()
    }
}