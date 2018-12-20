package com.example.fox.reactgit.arch.ui.favourite.presenter

import com.example.fox.reactgit.arch.domain.favourite.FavouriteInteractor
import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.favourite.view.IFavouriteView
import com.example.fox.reactgit.dto.User
import javax.inject.Inject
import com.example.fox.reactgit.di.scopes.FavouriteScope as Favourite

@Favourite
class FavouritePresenter @Inject constructor(private val interactor: FavouriteInteractor) : BasePresenter<IFavouriteView>(), IFavouritePresenter {
    override fun init() {
        view?.init()
    }

    override infix fun deleteUser(user: User) {
        interactor.deleteUser(user,
                { message ->
                    view?.infoMessage(message)
                },
                { error ->
                    view?.errorMessage(error.localizedMessage)
                })
    }

    override fun loadUsers() {
        interactor.getUsers(
                { users ->
                    view?.setList(users)
                },
                { error ->
                    view?.errorMessage(error.localizedMessage)
                })
    }

    override fun getUserRepositories(login: String) {
        interactor.getUserRepositories(login,
                {repositories->
                    view?.goInDetails(repositories)
                },
                {error->
                    view?.errorMessage(error.localizedMessage)
                })

    }

}