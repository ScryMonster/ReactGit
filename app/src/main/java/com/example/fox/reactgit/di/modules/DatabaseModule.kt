package com.example.fox.reactgit.di.modules

import android.content.Context
import com.example.fox.reactgit.db.db.UserDatabase
import com.example.fox.reactgit.di.qualifires.UserDaoQualifier
import com.example.fox.reactgit.di.scopes.ApplicationScope as Application
import dagger.Module
import dagger.Provides


@Module
class DatabaseModule {

    @Provides
    @Application
    @UserDaoQualifier
    fun provideUSerDao(context:Context) = UserDatabase.getInstance(context)!!.getUserDao()
}