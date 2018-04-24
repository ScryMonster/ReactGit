package com.example.fox.reactgit.di.components

import com.example.fox.reactgit.arch.ui.search.SearchActivity
import com.example.fox.reactgit.di.scopes.SearchActivityScope
import dagger.Subcomponent

@SearchActivityScope
@Subcomponent(modules = [])
interface SearchActivityComponent {

    @Subcomponent.Builder
    interface Builder{
        fun build() :SearchActivityComponent
    }

    fun inject(searchActivity: SearchActivity)
}