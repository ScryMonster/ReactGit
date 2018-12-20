package com.example.fox.reactgit.arch.ui.base.navigation

import com.example.fox.reactgit.arch.repositories.github_repository.GithubRepository
import com.example.fox.reactgit.dto.Repository

interface RootNavigation {

    fun openSearchFragment()
    fun closeSearchFragment()

    fun openFavouriteFragment()
    fun closeFavouriteFragment()

    fun openDetailFragment(repositories:List<Repository>)
    fun closeDetailFragment()
}