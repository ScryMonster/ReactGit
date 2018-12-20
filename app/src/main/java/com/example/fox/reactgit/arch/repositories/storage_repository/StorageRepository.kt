package com.example.fox.reactgit.arch.repositories.storage_repository

import com.example.fox.reactgit.db.dao.UserDao
import com.example.fox.reactgit.di.qualifires.UserDaoQualifier
import com.example.fox.reactgit.di.scopes.ApplicationScope as Application
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.ext.*
import javax.inject.Inject


@Application
class StorageRepository @Inject constructor(@UserDaoQualifier
                                            private val userDao: UserDao) : IStorageRepository {
    override fun saveUser(user: User,
                          success: (String) -> Unit,
                          errorHandler: (Exception) -> Unit) {
        userDao.addAsync(user).launchCoroutine({ success("User was successfully saved") }, errorHandler)
    }

    override fun deleteUser(user: User,
                            success: (String) -> Unit,
                            errorHandler: (Exception) -> Unit) {
        userDao.deleteAsync(user).launchCoroutine({ success("User was successfully deleted") }, errorHandler)
    }

    override fun getUser(id: String,
                         success: (User) -> Unit,
                         errorHandler: (Exception) -> Unit) {
        userDao.getAsync(id).launchCoroutine(success, errorHandler)
    }

    override fun getUsers(success: (List<User>) -> Unit,
                          errorHandler: (Exception) -> Unit) {
        userDao.getAsyncUsers().launchCoroutine(success, errorHandler)
    }

}