package com.example.fox.reactgit.utils.ext

import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.design.widget.TabLayout
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView

infix fun TextView.showTextViewsAsMandatory(text: String) {
    setText(Html.fromHtml("<html><body><font size=8></font> $text"))
}

infix fun EditText.showTextViewsAsMandatory(text: String) {
    setText(Html.fromHtml("<html><body><font size=8></body><html></font> $text"))
}

fun ViewGroup.inflate(layout: Int, attachToRoot: Boolean = false) = LayoutInflater.from(context).inflate(layout, this, attachToRoot)

/*
*
* */

infix fun <T : View> View.bind(@IdRes res: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy {
        findViewById(res) as T
    }
}




fun TabLayout.addTabWithCondition(condition: () -> Boolean): TabLayout.Tab? {
    if (condition.invoke()) {
        return newTab().also {
            addTab(it)
        }
    }
    return null
}

fun TabLayout.addTabWithCondition(condition: Boolean, code: (TabLayout.Tab) -> Unit) {
    if (condition) {
        newTab()
                .also { tab ->
                    addTab(tab)
                    code(tab)
                }
    }
}
fun TabLayout.addBenchmarkTab(condition: Boolean, code: (TabLayout.Tab,Boolean) -> Unit) {
    if (condition) {
        newTab()
                .also { tab ->
                    addTab(tab)
                    code(tab,condition)
                }
    }
}

infix fun TabLayout.Tab.setName(name: String) = apply {
    text = name
}
infix fun TabLayout.Tab.setName(@StringRes name: Int) = apply {
    setText(name)
}


fun TabLayout.addBenchmarkTab(name: String, condition: () -> Boolean) {
    if (condition.invoke()) {
        addTab(newTab().setText(name))
    }
}

