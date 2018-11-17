package com.example.fox.reactgit.arch.ui.base

interface IBaseView {
    fun init()
    fun infoMessage(message:String)
    fun infoMessage(message:Int)
    fun errorMessage(message:String)
    fun errorMessage(message:Int)
    fun switchOffUiInteraction(flag:Boolean)
}