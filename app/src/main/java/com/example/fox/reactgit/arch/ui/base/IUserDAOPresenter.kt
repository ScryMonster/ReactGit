package com.example.fox.reactgit.arch.ui.base

import com.example.fox.reactgit.dto.User

interface IUserDAOPresenter {
    fun deleteUser(user: User)
    fun saveUser(user: User)
}