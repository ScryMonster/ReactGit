package com.example.fox.reactgit.utils.delegates

import android.content.SharedPreferences
import com.example.fox.reactgit.arch.ui.base.SharedPreferenceProvider
import com.example.fox.reactgit.utils.ext.save
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringPreferenceDelegate(private val key:String="",
                               private val value: String, ) : ReadWriteProperty<SharedPreferenceProvider,String> {
    override fun getValue(thisRef: SharedPreferenceProvider, property: KProperty<*>): String {
        val key = key ifEmptyGetFrom property
        return thisRef.sharedPreferences.getString(key,value)
    }

    override fun setValue(thisRef: SharedPreferenceProvider, property: KProperty<*>, value: String) {
        val key = key ifEmptyGetFrom property
        thisRef.sharedPreferences.save(key, value)
    }

    private infix fun String.ifEmptyGetFrom(property: KProperty<*>):String = if (isEmpty()) property.name else this
}