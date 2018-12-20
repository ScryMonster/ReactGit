package com.example.fox.reactgit.di.modules

import com.example.fox.reactgit.arch.ui.base.navigation.SuppFragmentNavigator
import com.example.fox.reactgit.di.scopes.RootScope
import dagger.Provides

class RootModule(private val navigator: SuppFragmentNavigator) {

    @RootScope
    @Provides
    fun provideNavigator() = navigator
}