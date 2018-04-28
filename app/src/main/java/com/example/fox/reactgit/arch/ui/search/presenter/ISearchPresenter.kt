package com.example.fox.reactgit.arch.ui.search.presenter

import com.jakewharton.rxbinding2.InitialValueObservable as RxEditText


interface ISearchPresenter {
    fun searchGitUser(name:String)
    fun getUserRepositories(login:String)
    fun validateField(name: RxEditText<CharSequence>)
}