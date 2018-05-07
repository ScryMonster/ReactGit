package com.example.fox.reactgit.di.components

import com.example.fox.reactgit.arch.ui.favourite.view.FavouritesFragment
import com.example.fox.reactgit.di.scopes.FavouriteScope
import dagger.Subcomponent

@FavouriteScope
@Subcomponent(modules = [])
interface FavouriteComponent {

    @Subcomponent.Builder
    interface Builder{
        fun build():FavouriteComponent
    }

    fun inject(favouritesFragment: FavouritesFragment)
}