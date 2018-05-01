package com.example.fox.reactgit.di.components

import com.example.fox.reactgit.arch.ui.detail.view.DetailFragment
import com.example.fox.reactgit.di.scopes.DetailScope
import dagger.Subcomponent

@DetailScope
@Subcomponent(modules = [])
interface Detailcomponent {

    @Subcomponent.Builder
    interface Builder{
        fun build() : Detailcomponent
    }


    fun inject(detailFragment: DetailFragment)
}