package com.example.fox.reactgit.arch.repositories.storage_repository

import com.example.fox.reactgit.dto.User
import io.reactivex.Completable
import io.reactivex.Single

interface IStorageRepository {

    fun saveUser(user: User)

    fun deleteUser(user: User)

    fun getUser(id: String) : Single<User>

    fun getUsers() : Single<List<User>>
}