package com.example.fox.reactgit.arch.repositories.storage_repository

import com.example.fox.reactgit.db.dao.UserDao
import com.example.fox.reactgit.di.qualifires.UserDaoQualifier
import com.example.fox.reactgit.di.scopes.ApplicationScope as Application
import com.example.fox.reactgit.dto.User
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject


@Application
class StorageRepository @Inject constructor(@UserDaoQualifier private val userDao: UserDao) : IStorageRepository {
    override fun saveUser(user: User)  = userDao addUser user

    override fun deleteUser(user: User)  = userDao deleteUser user

    override fun getUser(id: String): Single<User>  = userDao getUserBy id

    override fun getUsers(): Single<List<User>>  = userDao.getUsers()

}