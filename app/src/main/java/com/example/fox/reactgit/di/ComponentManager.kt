package com.example.fox.reactgit.di

import android.content.Context
import com.example.fox.reactgit.di.components.AppComponent
import com.example.fox.reactgit.di.components.DaggerAppComponent
import com.example.fox.reactgit.di.components.SearchActivityComponent
import com.example.fox.reactgit.di.modules.ApplicationModule

class ComponentManager(private val context: Context) {

    private var appComponent: AppComponent? = null
    private var searchActComponent: SearchActivityComponent? = null


    fun addAppComponent(): AppComponent {
        if (appComponent == null) {
            appComponent = DaggerAppComponent
                    .builder()
                    .applicationModule(ApplicationModule(context.applicationContext))
                    .build()

        }

        return appComponent!!
    }

    fun addSearchActComponent(): SearchActivityComponent {
        if (searchActComponent == null) {
            searchActComponent = appComponent!!
                    .addSearchActivityComponent()
                    .build()
        }
        return searchActComponent!!
    }

    fun removeSearchActComponent(){
        searchActComponent = null
    }
}