package com.example.fox.reactgit.utils.delegates

import com.example.fox.reactgit.arch.ui.base.SharedPreferenceProvider
import kotlin.properties.ReadWriteProperty

object PreferencesDelegate{

    fun string(
            key: String = "",
            defaultValue: String = ""
    ): ReadWriteProperty<SharedPreferenceProvider, String> = StringPreferenceDelegate(key,defaultValue)
}