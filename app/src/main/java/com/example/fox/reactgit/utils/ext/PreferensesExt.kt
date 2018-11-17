package com.example.fox.reactgit.utils.ext

import android.content.SharedPreferences

fun SharedPreferences.save(key:String,value: String,force:Boolean = false){
    val editor = edit().putString(key, value)
    if (force) editor.commit() else editor.apply()
}