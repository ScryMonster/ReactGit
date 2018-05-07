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
    override fun deleteUser(user: User): Single<Boolean> = Single.fromCallable {
        storageRepository.deleteUser(user)
    }
            .map { true }

    override fun getUsers(): Single<List<User>> = storageRepository.getUsers()

    override fun getUserRepositories(login: String): Single<List<Repository>> = gitRepository.getUserRepositories(login)




}

