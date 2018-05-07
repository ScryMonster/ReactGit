package com.example.fox.reactgit.di.components

import com.example.fox.reactgit.application.ReactGit
import com.example.fox.reactgit.di.modules.ApplicationModule
import com.example.fox.reactgit.di.modules.DatabaseModule
import com.example.fox.reactgit.di.modules.NetworkModule
import com.example.fox.reactgit.di.scopes.ApplicationScope as Application
import dagger.Component

@Application
@Component(modules = [ApplicationModule::class,NetworkModule::class,DatabaseModule::class])
interface AppComponent {

    fun addSearchActivityComponent() : SearchActivityComponent.Builder
    fun addSearchFragmentComponent() : SearchFragmentComponent.Builder
    fun addDetailComponent() : Detailcomponent.Builder
    fun addFavouriteComponent() :FavouriteComponent.Builder



    fun inject(reactGit: ReactGit)
}