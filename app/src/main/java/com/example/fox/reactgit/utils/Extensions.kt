package com.example.fox.reactgit.utils

import android.graphics.Color
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.base.IBaseView


fun FragmentManager.addFragment(fragment: Fragment, place: Int, fragmentName: String) {
    this.beginTransaction()
            .add(place, fragment)
            .addToBackStack(fragmentName)
            .commit()
}

fun FragmentManager.replaceFragment(fragment: Fragment, place: Int,fragmentName:String? = null) {
    this.beginTransaction()
            .replace(place, fragment)
            .addToBackStack(fragmentName)
            .commit()
}

fun ViewGroup.inflate(layout: Int, attachToRoot: Boolean = false)
        = LayoutInflater.from(context).inflate(layout, this, attachToRoot)

fun String.showInSnackBarInWithAction(view: View, action: () -> Unit){
    val snackbar = Snackbar.make(view, this, Snackbar.LENGTH_LONG).run {
        addCallback(object : Snackbar.Callback(){
            override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                super.onDismissed(transientBottomBar, event)
                action()
            }
        })

        show()
    }

}

infix fun String.showInSnackBarIn(view: View) = Snackbar.make(view,this, Snackbar.LENGTH_LONG).show()


infix fun String.showInSnackBarInError(view: View){
    val snackbar = Snackbar.make(view, this, Snackbar.LENGTH_LONG)
    snackbar.view.run {
        setBackgroundColor(Color.RED)
    }
    snackbar.show()
}

operator fun <V: IBaseView>V.plus(presenter: BasePresenter<V>){
    presenter.attach(this)
}