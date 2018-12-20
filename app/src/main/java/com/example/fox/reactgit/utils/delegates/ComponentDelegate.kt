package com.example.fox.reactgit.utils.delegates

import android.support.v4.app.Fragment
import com.example.fox.reactgit.arch.ui.base.IBaseView
import com.example.fox.reactgit.arch.ui.detail.view.DetailFragment
import com.example.fox.reactgit.arch.ui.favourite.view.FavouritesFragment
import com.example.fox.reactgit.arch.ui.search.view.SearchFragment
import com.example.fox.reactgit.di.components.BaseComponent
import com.example.fox.reactgit.di.components.Detailcomponent
import com.example.fox.reactgit.di.components.SearchFragmentComponent
import java.lang.Exception
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ComponentDelegate<T: IBaseView>: ReadOnlyProperty<T,BaseComponent> {
    override fun getValue(thisRef: T, property: KProperty<*>): BaseComponent  = when(thisRef){
            is SearchFragment -> thisRef.manager.addSearcFragmentComponent()
            is DetailFragment -> thisRef.manager.addDetailComponent()
            is FavouritesFragment -> thisRef.manager.addFavouriteComponent()
        else -> throw Exception()
    }


}