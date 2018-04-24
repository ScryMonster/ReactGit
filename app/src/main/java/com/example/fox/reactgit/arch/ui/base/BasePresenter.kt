package com.example.fox.reactgit.arch.ui.base

import android.view.View
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T:IBaseView> : IBasePresenter<T>{

    private var view : T? = null
    protected val clearedDisposable = CompositeDisposable()


    override fun attach(view: T) {
        this.view = view
    }

    override fun detach() {
        view = null
        clearedDisposable.clear()
    }

    abstract override fun init()

    protected fun getMvpView() = view

    fun onShowProgress(tag:Any) = view?.showProgress(tag)

    fun onShowProgress() = view?.showProgress(null)

    fun onInfoMessage(message:String) = view?.infoMessage(message)



}