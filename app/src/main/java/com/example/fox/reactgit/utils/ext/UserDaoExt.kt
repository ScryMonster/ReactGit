package com.example.fox.reactgit.utils.ext

import com.example.fox.reactgit.db.dao.UserDao
import com.example.fox.reactgit.dto.User
import kotlinx.coroutines.experimental.async

infix fun UserDao.addAsync(user: User) = async { addUser(user) }
infix fun UserDao.deleteAsync(user: User) = async { deleteUser(user) }
infix fun UserDao.getAsync(id: String) = async { getUserBy(id) }
fun UserDao.getAsyncUsers() = async { getUsers() }