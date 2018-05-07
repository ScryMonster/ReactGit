package com.example.fox.reactgit.arch.ui.base

interface IBaseView {
    fun showProgress(tag: Any?)
    fun hideProgress(tag: Any?)
    fun init()
    fun buildGraph()
    fun destroyGraph()
    fun infoMessage(message:String)
    fun infoMessage(message:Int)
    fun errorMessage(message:String)
    fun errorMessage(message:Int)
    fun makeBackgroundVisibleWhileProgrees(flag:Boolean)
}