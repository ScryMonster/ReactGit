package com.example.fox.reactgit.di.modules

import com.example.fox.reactgit.BuildConfig
import com.example.fox.reactgit.arch.domain.service.GitHubClientService
import com.example.fox.reactgit.di.qualifires.CoroutinesCallAdapter
import com.example.fox.reactgit.di.qualifires.RxCallAdapter
import com.example.fox.reactgit.di.scopes.ApplicationScope as Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by totskiy on 27.04.18.
 */
@Module
class NetworkModule {


    @Application
    @Provides
    fun provideGithubClient(retrofit: Retrofit):GitHubClientService = retrofit.create(GitHubClientService::class.java)







    @Application
    @Provides
    fun provideRetrofit(converterFactory: Converter.Factory,
                        @CoroutinesCallAdapter callAdapterFactory: CallAdapter.Factory): Retrofit =
            Retrofit.Builder()
                    .baseUrl(BuildConfig.GITHUB_API_BASE_URL)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(callAdapterFactory)
                    .build()

    @Application
    @Provides
    fun provideConverterFactory(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)

    @Application
    @RxCallAdapter
    @Provides
    fun provideRxCallAdapter(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    @Application
    @CoroutinesCallAdapter
    @Provides
    fun provideCoroutineCallAdapter():CallAdapter.Factory = CoroutineCallAdapterFactory()



    @Application
    @Provides
    fun provideGson(): Gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create()

}