package com.example.fox.reactgit.arch.ui.base.navigation

import com.example.fox.reactgit.utils.enums.Screens

interface SuppFragmentNavigator {

    fun goTo(key: Screens, vararg data: Any?)

    fun backTo(key: String?, data: Any?)

    fun back()

    fun replace(key: String, data: Any)

    fun systemMessage(message: String)

}