package com.example.fox.reactgit.di.modules

import android.content.Context
import com.example.fox.reactgit.BuildConfig
import com.example.fox.reactgit.di.scopes.ApplicationScope as Application
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule(private val app: Context){


    @Provides
    @Application
    fun provideContext() = app.applicationContext

    @Provides
    @Application
    fun provideSharePreferences() = app.getSharedPreferences(BuildConfig.SHARED_PREF_BASE_KEY, Context.MODE_PRIVATE)



}