package com.example.fox.reactgit.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.fox.reactgit.dto.User
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert
    infix fun addUser(user: User)

    @Insert
    fun addUsers(vararg user: User)

    @Insert
    infix fun addUsers(list:List<User>)

    @Delete
    infix fun deleteUser(user: User)

    @Delete
    fun deleteUsers(vararg user: User)

    @Delete
    infix fun deleteUsers(list:List<User>)

    @Query("Select  * From users Where id=:id")
    infix fun getUserBy(id:String) : User

    @Query("Select  * From users")
    fun getUsers() : List<User>

}