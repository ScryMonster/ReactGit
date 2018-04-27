package com.example.fox.reactgit.di.components

import com.example.fox.reactgit.arch.ui.search.view.SearchFragment
import com.example.fox.reactgit.di.scopes.SearchScope as Search
import dagger.Subcomponent

/**
 * Created by totskiy on 27.04.18.
 */
@Search
@Subcomponent(modules = [])
interface SearchFragmentComponent {



    @Subcomponent.Builder
    interface Builder{
        fun build() : SearchFragmentComponent
    }

    fun inject(searchFragment:SearchFragment)
}