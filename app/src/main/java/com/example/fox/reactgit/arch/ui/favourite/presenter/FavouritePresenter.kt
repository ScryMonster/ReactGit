package com.example.fox.reactgit.arch.ui.favourite.presenter

import com.example.fox.reactgit.arch.domain.favourite.FavouriteInteractor
import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.favourite.view.IFavouriteView
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.ext.applySchedulers
import com.example.fox.reactgit.utils.ext.showProgress
import javax.inject.Inject
import com.example.fox.reactgit.di.scopes.FavouriteScope as Favourite

@Favourite
class FavouritePresenter @Inject constructor(private val interactor:FavouriteInteractor) : BasePresenter<IFavouriteView>(),IFavouritePresenter {
    override fun init() {
        getView()?.init()
    }

    override fun deleteUser(user: User) {
        interactor.deleteUser(user)
                .applySchedulers()
                .subscribe({
                    getView()?.infoMessage("Cleared")
                },{
                    getView()?.errorMessage("Cleared")
                })
    }

    override fun loadUsers() {
        interactor.getUsers()
                .applySchedulers()
                .showProgress(getView()!!)
                .subscribe({
                    getView()?.setList(it)
                },{
                    getView()?.errorMessage(it.localizedMessage!!)
                })
    }

    override fun getUserRepositories(login: String) {
        interactor.getUserRepositories(login)
                .applySchedulers()
                .showProgress(getView()!!)
                .subscribe({
                    getView()?.replacment(it)
                }, { error ->
                    getView()?.errorMessage(error.localizedMessage)
                })

    }

}