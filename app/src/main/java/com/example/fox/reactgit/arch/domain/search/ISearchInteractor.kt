package com.example.fox.reactgit.arch.domain.search

import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import io.reactivex.Observable
import io.reactivex.Single
import com.jakewharton.rxbinding2.InitialValueObservable as RxObservable

interface ISearchInteractor {
    fun searchGitUser(name: String) : Single<List<User>>
    fun validateField(name: RxObservable<CharSequence>) : Observable<String>
    fun getUserRepositories(login:String) : Single<List<Repository>>
}