package com.example.fox.reactgit.arch.repositories.storage_repository

import com.example.fox.reactgit.dto.User
import kotlinx.coroutines.experimental.Deferred

interface IStorageRepository {

    fun saveUser(user: User,
                 success: (String) -> Unit,
                 errorHandler: (Exception) -> Unit)

    fun deleteUser(user: User,
                   success: (String) -> Unit,
                   errorHandler: (Exception) -> Unit)

    fun getUser(id: String,
                success: (User) -> Unit,
                errorHandler: (Exception) -> Unit)

    fun getUsers(success: (List<User>) -> Unit,
                 errorHandler: (Exception) -> Unit)
}