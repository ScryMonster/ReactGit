package com.example.fox.reactgit.db.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.fox.reactgit.db.dao.UserDao
import com.example.fox.reactgit.dto.User


@Database(entities = arrayOf(User::class),version = 1)
abstract class UserDatabase : RoomDatabase(){
    companion object {
        private const val DB_NAME = "userDatabase.db"
        private var instance:UserDatabase? = null

        fun getInstance(context: Context): UserDatabase?{
            if (instance == null){
                instance = create(context)
            }
            return instance
        }

        private fun create(context: Context) : UserDatabase =
                Room.databaseBuilder(context,
                        UserDatabase::class.java,
                        DB_NAME).build()
    }


    abstract fun getUserDao(): UserDao


}