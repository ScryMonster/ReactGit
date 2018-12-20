package com.example.fox.reactgit.arch.domain.search

import com.example.fox.reactgit.arch.repositories.github_repository.GithubRepository
import com.example.fox.reactgit.arch.repositories.storage_repository.StorageRepository
import com.example.fox.reactgit.di.scopes.SearchScope
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.ext.launchCoroutine
import com.jakewharton.rxbinding2.InitialValueObservable
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@SearchScope
class SearchInteractor @Inject constructor(private val gitRepository: GithubRepository,
                                           private val storageRepository: StorageRepository) : ISearchInteractor {

    override fun searchGitUser(name: String,
                               success: (List<User>) -> Unit,
                               errorHandler: (Exception) -> Unit) {
        gitRepository.searchGitUser(name, { response -> success(response.users) }, errorHandler)
    }


    override fun validateField(name: InitialValueObservable<CharSequence>): Observable<String> =
            name.debounce(800, TimeUnit.MILLISECONDS)
                    .filter { it.length > 2 }
                    .map { it.toString() }


    override fun getUserRepositories(login: String,
                                     success: (List<Repository>) -> Unit,
                                     errorHandler: (Exception) -> Unit) {
        gitRepository.getUserRepositories(login,success,errorHandler)
    }

    override fun saveUser(user: User,
                          success: (String) -> Unit,
                          errorHandler: (Exception) -> Unit) {
        storageRepository.saveUser(user,success,errorHandler)
    }

    override fun deleteUser(user: User,
                            success: (String) -> Unit,
                            errorHandler: (Exception) -> Unit) {
        storageRepository.deleteUser(user,success,errorHandler)
    }
}

