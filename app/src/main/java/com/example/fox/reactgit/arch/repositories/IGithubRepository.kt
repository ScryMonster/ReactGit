package com.example.fox.reactgit.arch.repositories

import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.dto.UserResponse
import io.reactivex.Single

interface IGithubRepository {

    fun searchGitUser(name: String): Single<UserResponse>

    fun getUserRepositories(login: String): Single<List<Repository>>
}