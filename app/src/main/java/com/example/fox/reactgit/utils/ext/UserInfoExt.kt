package com.example.fox.reactgit.utils.ext

import android.content.Context
import android.graphics.Color
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import com.example.fox.reactgit.R

fun String.showInSnackBarWithDismissedAction(view: View, action: () -> Unit) {
    val snackbar = Snackbar.make(view, this, Snackbar.LENGTH_LONG).run {
        addCallback(object : Snackbar.Callback() {
            override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                super.onDismissed(transientBottomBar, event)
                action()
            }
        })

        show()
    }

}


infix fun String.showInfoInSnackBar(view: View){
    val snackbar = Snackbar.make(view, this, Snackbar.LENGTH_LONG)
    snackbar.view.run {
        setBackgroundColor(this.context.resources.getColor(R.color.good_password))
    }
    snackbar.setActionTextColor(Color.BLACK)
    snackbar.show()
}


infix fun String.showErrorInSnackBar(view: View) {
    val snackbar = Snackbar.make(view, this, Snackbar.LENGTH_LONG)
    snackbar.view.run {
            setBackgroundColor(Color.RED)
        }
    snackbar.show()


}

infix fun Int.showInfoInSnackBar(view: View){
    val snackbar = Snackbar.make(view, this, Snackbar.LENGTH_LONG)
    snackbar.view.run {
            setBackgroundColor(this.context.resources.getColor(R.color.good_password))
        }
        snackbar.setActionTextColor(Color.BLACK)
        snackbar.show()


}


infix fun Int.showErrorInSnackBar(view: View) {
    val snackbar = Snackbar.make(view, this, Snackbar.LENGTH_LONG)
    snackbar.view.run {
            setBackgroundColor(Color.RED)
        }
    snackbar.show()

}

infix fun String.showToast(context: Context) = Toast.makeText(context,this, Toast.LENGTH_SHORT).show()
infix fun Int.showToast(context: Context) = Toast.makeText(context,this, Toast.LENGTH_SHORT).show()
