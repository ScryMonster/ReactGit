package com.example.fox.reactgit.di.components

import com.example.fox.reactgit.arch.ui.base.navigation.SuppFragmentNavigator
import com.example.fox.reactgit.arch.ui.search.RootActivity
import com.example.fox.reactgit.di.modules.RootModule
import com.example.fox.reactgit.di.scopes.RootScope
import dagger.Subcomponent

@RootScope
@Subcomponent(modules = [RootModule::class])
interface RootActComponent :BaseComponent{

    @Subcomponent.Builder
    interface Builder{
        fun addRootModule(navigator: SuppFragmentNavigator):RootActComponent.Builder
        fun build() :RootActComponent
    }

    fun inject(searchActivity: RootActivity)
}