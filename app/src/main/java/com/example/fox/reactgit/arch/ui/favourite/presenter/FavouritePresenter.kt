package com.example.fox.reactgit.arch.ui.favourite.presenter

import com.example.fox.reactgit.arch.domain.favourite.FavouriteInteractor
import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.favourite.view.IFavouriteView
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.applySchedulers
import com.example.fox.reactgit.utils.showProgress
import javax.inject.Inject
import com.example.fox.reactgit.di.scopes.FavouriteScope as Favourite

@Favourite
class FavouritePresenter @Inject constructor(private val interactor:FavouriteInteractor) : BasePresenter<IFavouriteView>(),IFavouritePresenter {
    override fun init() {
        getMvpView()?.init()
    }

    override fun deleteUser(user: User) {
        interactor.deleteUser(user)
                .applySchedulers()
                .subscribe({
                    getMvpView()?.infoMessage("Cleared")
                },{
                    getMvpView()?.errorMessage("Cleared")
                })
    }

    override fun loadUsers() {
        interactor.getUsers()
                .applySchedulers()
                .showProgress(getMvpView()!!)
                .subscribe({
                    getMvpView()?.setList(it)
                },{
                    getMvpView()?.errorMessage(it.localizedMessage!!)
                })
    }

    override fun getUserRepositories(login: String) {
        interactor.getUserRepositories(login)
                .applySchedulers()
                .showProgress(getMvpView()!!)
                .subscribe({
                    getMvpView()?.replacment(it)
                }, { error ->
                    getMvpView()?.errorMessage(error.localizedMessage)
                })

    }

}