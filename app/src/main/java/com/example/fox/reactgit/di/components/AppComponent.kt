package com.example.fox.reactgit.di.components

import com.example.fox.reactgit.application.ReactGit
import com.example.fox.reactgit.di.modules.ApplicationModule
import com.example.fox.reactgit.di.scopes.ApplicationScope as Application
import dagger.Component

@Application
@Component(modules = [ApplicationModule::class])
interface AppComponent {

    fun addSearchActivityComponent() : SearchActivityComponent.Builder



    fun inject(reactGit: ReactGit)
}