package com.example.fox.reactgit.arch.repositories.github_repository

import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.UserResponse

interface IGithubRepository {

    fun searchGitUser(name: String, success: (UserResponse)->Unit,errorHandler:(Exception)->Unit)

    fun getUserRepositories(login: String,success:(List<Repository>)->Unit,errorHandler:(Exception)->Unit)
}