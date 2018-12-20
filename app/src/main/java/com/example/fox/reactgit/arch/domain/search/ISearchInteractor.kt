package com.example.fox.reactgit.arch.domain.search

import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.dto.UserResponse
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import com.jakewharton.rxbinding2.InitialValueObservable as RxObservable

interface ISearchInteractor {
    fun searchGitUser(name: String,success: (List<User>)->Unit,errorHandler: (Exception)->Unit)
    fun validateField(name: RxObservable<CharSequence>) : Observable<String>
    fun getUserRepositories(login:String,success: (List<Repository>)->Unit,errorHandler: (Exception)->Unit)
    fun saveUser(user: User,success: (String)->Unit,errorHandler: (Exception)->Unit)
    fun deleteUser(user: User,success: (String)->Unit,errorHandler: (Exception)->Unit)
}