package com.example.fox.reactgit.arch.ui.search.presenter

import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.domain.search.SearchInteractor
import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.search.view.ISearchView
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.ext.applySchedulers
import com.example.fox.reactgit.utils.ext.withProgress
import com.jakewharton.rxbinding2.InitialValueObservable
import com.example.fox.reactgit.di.scopes.SearchScope as Search
import javax.inject.Inject

@Search
class SearchPresenter @Inject constructor(private val interactor: SearchInteractor) : BasePresenter<ISearchView>(), ISearchPresenter {
    override fun init() {
        view?.init()
    }

    override fun searchGitUser(name: String) {
        withProgress {
            interactor.searchGitUser(name,
                    { users -> setList(users) },
                    { error -> errorMessage(error.localizedMessage) }
            )
        }
    }

    override fun getUserRepositories(login: String) {
        withProgress {
            interactor.getUserRepositories(login,
                    { repositories -> goInDetails(repositories) },
                    { error -> errorMessage(error.localizedMessage) }
            )
        }
    }

    override fun validateField(name: InitialValueObservable<CharSequence>) {
        interactor.validateField(name)
                .applySchedulers()
                .subscribe({
                    view?.startSearching(it)
                }, {
                    view?.errorMessage(it.localizedMessage)
                })
    }

    override infix fun saveUser(user: User) {
        interactor.saveUser(user,
                { message ->
                    view?.infoMessage(message)
                    user.saved = true
                },
                { error -> view?.errorMessage(error.localizedMessage) }
        )
    }

    override infix fun deleteUser(user: User) {
        interactor.deleteUser(user,
                { message -> view?.infoMessage(message) },
                { error -> view?.errorMessage(error.localizedMessage) }
        )
    }
}