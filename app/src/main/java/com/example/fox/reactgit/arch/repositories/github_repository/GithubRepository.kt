package com.example.fox.reactgit.arch.repositories.github_repository

import com.example.fox.reactgit.arch.domain.service.GitHubClientService
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.UserResponse
import com.example.fox.reactgit.utils.ext.launchCoroutine
import javax.inject.Inject
import com.example.fox.reactgit.di.scopes.ApplicationScope as Application

@Application
class GithubRepository @Inject constructor(private val service: GitHubClientService) : IGithubRepository {

    override fun searchGitUser(name: String, success: (UserResponse) -> Unit, errorHandler: (Exception) -> Unit) {
        service.getGithubUsers(name).launchCoroutine(success, errorHandler)
    }


    override fun getUserRepositories(login: String, success: (List<Repository>) -> Unit, errorHandler: (Exception) -> Unit) {
        service.getUserRepositories(login).launchCoroutine(success, errorHandler)
    }

}