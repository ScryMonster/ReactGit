package com.example.fox.reactgit.arch.ui.base

import android.view.View
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.experimental.Job

abstract class BasePresenter<T:IBaseView> : IBasePresenter<T>{

    private var view : T? = null
    protected val clearedDisposable = CompositeDisposable()
    val parentJob = Job()


    override fun attach(view: T) {
        this.view = view
    }

    override fun detach() {
        view = null
        clearedDisposable.clear()
    }

    abstract override fun init()

    fun getView() = view!!

    fun onInfoMessage(message:String) = view?.infoMessage(message)



}