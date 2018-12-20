package com.example.fox.reactgit.arch.ui.base.navigation

import com.example.fox.reactgit.di.scopes.RootScope
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.utils.enums.Screens.*

@RootScope
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

    override fun openDetailFragment(repositories: List<Repository>) {
        navigator.goTo(DETAIL,repositories)
    }

    override fun closeDetailFragment() {
        navigator.back()
    }
}