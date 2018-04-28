package com.example.fox.reactgit.arch.domain.search

import com.example.fox.reactgit.arch.domain.service.GitHubClientService
import com.example.fox.reactgit.arch.repositories.GithubRepository
import com.example.fox.reactgit.di.scopes.SearchScope
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import com.jakewharton.rxbinding2.InitialValueObservable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@SearchScope
class SearchInteractor @Inject constructor(private val repository:GithubRepository) : ISearchInteractor {

    override fun searchGitUser(name: String): Single<List<User>>  = repository.searchGitUser(name)


    override fun validateField(name: InitialValueObservable<CharSequence>): Observable<String>  = name.debounce(2,TimeUnit.SECONDS)
            .filter { it.length < 2 }
            .map { it.toString() }


    override fun getUserRepositories(login: String): Single<List<Repository>> = repository.getUserRepositories(login)

}