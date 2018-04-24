package com.example.fox.reactgit.arch.ui.base

interface IBasePresenter<in V> {
    fun attach(view:V)
    fun detach()
    fun init()
}