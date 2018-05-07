package com.example.fox.reactgit.arch.domain.favourite

import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import io.reactivex.Single

interface IFavouriteInteractor{
    fun deleteUser(user: User) : Single<Boolean>
    fun getUsers() : Single<List<User>>
    fun getUserRepositories(login:String) : Single<List<Repository>>

}