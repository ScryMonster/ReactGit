package com.example.fox.reactgit.utils.ext

import android.util.Log

infix fun String.infoLog(tag:String) = Log.i(tag,this)

infix fun String.errorLog(tag:String) = Log.e(tag,this)