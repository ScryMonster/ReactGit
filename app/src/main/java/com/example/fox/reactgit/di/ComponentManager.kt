package com.example.fox.reactgit.di

import android.content.Context
import com.example.fox.reactgit.arch.ui.base.navigation.SuppFragmentNavigator
import com.example.fox.reactgit.di.components.*
import com.example.fox.reactgit.di.modules.ApplicationModule

class ComponentManager(private val context: Context) {

    private var appComponent: AppComponent? = null
    private var rootActComponent: RootActComponent? = null
    private var searchFragmentComponent: SearchFragmentComponent? = null
    private var detailcomponent: Detailcomponent? = null
    private var favouriteComponent: FavouriteComponent? = null


    fun addAppComponent(): AppComponent {
        if (appComponent == null) {
            appComponent = DaggerAppComponent
                    .builder()
                    .applicationModule(ApplicationModule(context.applicationContext))
                    .build()

        }

        return appComponent!!
    }

    fun addRootActComponent(navigator: SuppFragmentNavigator): RootActComponent {
        if (rootActComponent == null) {
            rootActComponent = appComponent!!
                    .addRootActComponent()
                    .addRootModule(navigator)
                    .build()
        }
        return rootActComponent!!
    }

    fun removeRootActComponent() {
        rootActComponent = null
    }


    fun addSearcFragmentComponent(): SearchFragmentComponent {
        if (searchFragmentComponent == null) {
            searchFragmentComponent = appComponent!!
                    .addSearchFragmentComponent()
                    .build()
        }
        return searchFragmentComponent!!
    }

    fun removeSearchhFragmentComponent(){
        searchFragmentComponent = null
    }

    fun addDetailComponent() : Detailcomponent{
        if (detailcomponent == null){
            detailcomponent = appComponent!!
                    .addDetailComponent()
                    .build()
        }
        return detailcomponent!!
    }

    fun removeDetailComponent(){
        detailcomponent = null
    }

    fun addFavouriteComponent() : FavouriteComponent{
        if (favouriteComponent == null){
            favouriteComponent = appComponent!!
                    .addFavouriteComponent()
                    .build()
        }
        return favouriteComponent!!
    }
    fun removeFavouriteComponent(){
        favouriteComponent = null
    }

}