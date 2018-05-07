package com.example.fox.reactgit.arch.domain.search

import com.example.fox.reactgit.arch.repositories.github_repository.GithubRepository
import com.example.fox.reactgit.arch.repositories.storage_repository.StorageRepository
import com.example.fox.reactgit.di.scopes.SearchScope
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.dto.UserResponse
import com.jakewharton.rxbinding2.InitialValueObservable
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@SearchScope
class SearchInteractor @Inject constructor(private val gitRepository: GithubRepository,
                                           private val storageRepository: StorageRepository) : ISearchInteractor {

    override fun searchGitUser(name: String): Single<List<User>> = gitRepository.searchGitUser(name)
            .map { it.items }


    override fun validateField(name: InitialValueObservable<CharSequence>): Observable<String> = name.debounce(800, TimeUnit.MILLISECONDS)
            .filter { it.length > 2 }
            .map { it.toString() }


    override fun getUserRepositories(login: String): Single<List<Repository>> = gitRepository.getUserRepositories(login)

    override fun saveUser(user: User) =
            Single.fromCallable {
                storageRepository.saveUser(user)
            }
                    .map { true }

    override fun deleteUser(user: User) = Single.fromCallable {
        storageRepository.deleteUser(user)
    }
            .map { true }

}