package com.example.fox.reactgit.arch.ui.base

interface IBaseView {
    fun showProgress(tag: Any?)
    fun hideProgress(tag: Any?)
    fun init()
    fun buildGraph()
    fun destroyGraph()
    fun infoMessage(message:String)
    fun errorMessage(message:String)
    fun makeBackgroundVisibleWhileProgrees(flag:Boolean)
}