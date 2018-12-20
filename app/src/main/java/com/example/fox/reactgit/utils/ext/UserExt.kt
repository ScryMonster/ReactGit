package com.example.fox.reactgit.utils.ext

import com.example.fox.reactgit.arch.ui.search.presenter.SearchPresenter
import com.example.fox.reactgit.dto.User

fun User.isNotSaved(presenter: SearchPresenter,code:SearchPresenter.(User)->Unit){
    if (!saved) presenter.code(this) else presenter.deleteUser(this)
}

fun User.isNotSaved(presenter: SearchPresenter,
                    isNotSaved:SearchPresenter.()->Unit,
                    isSaved:SearchPresenter.()->Unit){
    if (!saved) presenter.isNotSaved()
    else presenter.isSaved()
}