package com.example.fox.reactgit.arch.repositories.github_repository

import com.example.fox.reactgit.arch.domain.service.GitHubClientService
import com.example.fox.reactgit.di.scopes.ApplicationScope as Application
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.UserResponse
import io.reactivex.Single
import javax.inject.Inject

@Application
class GithubRepository @Inject constructor(private val service: GitHubClientService) : IGithubRepository {

    override fun searchGitUser(name: String): Single<UserResponse>  = service.getGithubUsers(name)

    override fun getUserRepositories(login: String): Single<List<Repository>>  = service.getUserRepositories(login)

}