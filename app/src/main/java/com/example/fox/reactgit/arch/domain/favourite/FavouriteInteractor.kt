package com.example.fox.reactgit.arch.domain.favourite

import com.example.fox.reactgit.arch.repositories.github_repository.GithubRepository
import com.example.fox.reactgit.arch.repositories.storage_repository.StorageRepository
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.di.scopes.FavouriteScope as Favourite
import com.example.fox.reactgit.dto.User
import io.reactivex.Single
import javax.inject.Inject

@Favourite
class FavouriteInteractor @Inject constructor(private val gitRepository: GithubRepository,
                                              private val storageRepository: StorageRepository) : IFavouriteInteractor {
    override fun deleteUser(user: User,
                            success: (String) -> Unit,
                            errorHandler: (Exception) -> Unit) {
        storageRepository.deleteUser(user,success,errorHandler)
    }
    override fun getUsers(success: (List<User>) -> Unit,
                          errorHandler: (Exception) -> Unit) {
        storageRepository.getUsers(success, errorHandler)
    }

    override fun getUserRepositories(login: String,
                                     success: (List<Repository>) -> Unit,
                                     errorHandler: (Exception) -> Unit) {
        gitRepository.getUserRepositories(login,success,errorHandler)
    }




}

