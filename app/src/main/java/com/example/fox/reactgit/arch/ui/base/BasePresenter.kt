package com.example.fox.reactgit.arch.ui.base

import android.view.View
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.experimental.Job

abstract class BasePresenter<V:IBaseView> : IBasePresenter<V>{

    var view : V? = null
    protected val clearedDisposable = CompositeDisposable()
    val parentJob = Job()


    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        view = null
        clearedDisposable.clear()
    }

    abstract override fun init()

    fun onInfoMessage(message:String) = view?.infoMessage(message)



}