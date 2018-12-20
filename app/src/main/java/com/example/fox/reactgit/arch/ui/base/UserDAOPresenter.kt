package com.example.fox.reactgit.arch.ui.base

import com.example.fox.reactgit.dto.User

abstract class UserDAOPresenter<V> : BasePresenter<V>(),IUserDAOPresenter where  V:IProgressView,V:IPreDetailsView {
    abstract override fun init()

    override fun saveUser(user: User) {

    }




}