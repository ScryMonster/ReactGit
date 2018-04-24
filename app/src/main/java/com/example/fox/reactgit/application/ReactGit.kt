package com.example.fox.reactgit.application

import android.app.Application
import com.example.fox.reactgit.di.ComponentManager

class ReactGit  : Application(){

    val manager by lazy {
        ComponentManager(this)
    }

    override fun onCreate() {
        super.onCreate()
        manager.addAppComponent().inject(this)
    }


}