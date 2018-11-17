package com.example.fox.reactgit.di

import android.content.Context
import com.example.fox.reactgit.BuildConfig
import com.example.fox.reactgit.arch.domain.service.GitHubClientService
import com.example.fox.reactgit.arch.ui.base.navigation.RootRouter
import com.example.fox.reactgit.arch.ui.search.RootPresenter
import com.example.fox.reactgit.arch.ui.search.SearchActivityPresenter
import com.example.fox.reactgit.db.dao.UserDao
import com.example.fox.reactgit.db.db.UserDatabase
import com.example.fox.reactgit.utils.enums.KoinScopes.*
import com.example.fox.reactgit.utils.enums.RoomTables.UserTable
import com.example.fox.reactgit.utils.enums.SharedPreferencesTypes.Base
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class KoinModulesHandler(context: Context){

    val modules = arrayListOf<Module>().apply {
        add(rootModule)
        add(roomModule)
        add(netModule)
        add(apiModule)
    }

    val rootModule:Module = module {
        single(Base.value) { context.applicationContext.getSharedPreferences(BuildConfig.SHARED_PREF_BASE_KEY, Context.MODE_PRIVATE) }
        single<Context>("ApplicationContext") { context.applicationContext }
    }

    val roomModule = module {
        single<UserDao>(UserTable.value) {
            UserDatabase.getInstance(context)!!.getUserDao()
        }
    }

    val netModule = module {
        single { GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create()
        }
        single<CallAdapter.Factory>{
            CoroutineCallAdapterFactory()
        }

        single<Converter.Factory> {
            GsonConverterFactory.create(get())
        }

        single {
            (callAdapter:CallAdapter.Factory,converter:Converter.Factory) -> Retrofit.Builder()
                .baseUrl(BuildConfig.GITHUB_API_BASE_URL)
                .addCallAdapterFactory(callAdapter)
                .addConverterFactory(converter)
                .build()
        }
    }

    val apiModule = module {
        single { (retrofit:Retrofit) -> retrofit.create(GitHubClientService::class.java)}

    }

    val activityModile = module("RootActivity") {
        scope(RootActivity.value){
            RootPresenter(get())
        }
        scope(RootActivity.value){
            RootRouter(get())
        }
    }


}