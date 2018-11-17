package com.example.fox.reactgit.utils.ext

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.example.fox.reactgit.R

fun FragmentManager.addFragment(fragment: Fragment,
                                @IdRes place:Int = R.id.container,
                                tag:String){
    this.beginTransaction()
            .add(place,fragment)
            .addToBackStack(tag)
            .commit()

}


fun FragmentManager.replaceFragment(fragment: Fragment,
                                    @IdRes place:Int = R.id.container,
                                    tag:String){
    this.beginTransaction()
            .replace(place,fragment)
            .addToBackStack(tag)
            .commit()
}


fun FragmentManager.replaceFragmentWithoutBackStack(fragment: Fragment,
                                    @IdRes place:Int = R.id.container){
    this.beginTransaction()
            .replace(place,fragment)
            .commit()
}