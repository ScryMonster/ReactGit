package com.example.fox.reactgit.arch.domain.favourite

import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import io.reactivex.Single

interface IFavouriteInteractor{
    fun deleteUser(user: User,
                   success: (String) -> Unit,
                   errorHandler: (Exception)->Unit
    )
    fun getUsers(success: (List<User>) -> Unit,
                 errorHandler: (Exception)->Unit
    )
    fun getUserRepositories(login:String,
                            success: (List<Repository>) -> Unit,
                            errorHandler: (Exception)->Unit
    )

}