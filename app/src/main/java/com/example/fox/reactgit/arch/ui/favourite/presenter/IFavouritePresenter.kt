package com.example.fox.reactgit.arch.ui.favourite.presenter

import com.example.fox.reactgit.dto.User

interface IFavouritePresenter {
    fun deleteUser(user: User)
    fun loadUsers()
    fun getUserRepositories(login:String)
}