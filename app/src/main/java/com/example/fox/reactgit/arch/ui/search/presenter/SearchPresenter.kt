package com.example.fox.reactgit.arch.ui.search.presenter

import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.domain.search.SearchInteractor
import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.search.view.ISearchView
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.ext.applySchedulers
import com.example.fox.reactgit.utils.ext.showProgress
import com.jakewharton.rxbinding2.InitialValueObservable
import com.example.fox.reactgit.di.scopes.SearchScope as Search
import javax.inject.Inject

@Search
class SearchPresenter @Inject constructor(private val interactor: SearchInteractor) : BasePresenter<ISearchView>(), ISearchPresenter {
    override fun init() {
        getView()?.init()
    }

    override fun searchGitUser(name: String) {
        interactor.searchGitUser(name)
                .applySchedulers()
                .showProgress(getView()!!)
                .subscribe({ list ->
                    getView()?.setList(list)
                }, { error ->
                    getView()?.errorMessage(error.localizedMessage)
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

    override fun validateField(name: InitialValueObservable<CharSequence>) {
        interactor.validateField(name)
                .applySchedulers()
                .subscribe({
                    getView()?.startSearching(it)
                }, {
                    getView()?.errorMessage(it.localizedMessage)
                })
    }

    override fun saveUser(user: User) {
        interactor.saveUser(user)
                .applySchedulers()
                .subscribe({
                    getView()?.infoMessage(R.string.db_user_saved)
                },{
                    getView()?.errorMessage(it.localizedMessage)
                })
    }

    override fun deleteUser(user: User) {
        interactor.deleteUser(user)
                .applySchedulers()
                .subscribe({
                   getView()?.infoMessage(R.string.db_user_deleted)
                },{
                    getView()?.errorMessage(it.localizedMessage)
                })
    }
}