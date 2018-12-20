package com.example.fox.reactgit.arch.domain.service

import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.dto.UserResponse
import io.reactivex.Single
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by totskiy on 27.04.18.
 */
interface GitHubClientService {

    @GET("search/users")
    fun getGithubUsers(@Query("q") term:String? = null) : Deferred<UserResponse>

    @GET("users/{user}/repos")
    fun getUserRepositories(@Path("user") name:String) : Deferred<List<Repository>>

}