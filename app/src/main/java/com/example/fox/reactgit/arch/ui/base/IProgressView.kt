package com.example.fox.reactgit.arch.ui.base

interface IProgressView:IBaseView {
    fun showProgress(tag: Any?)
    fun hideProgress(tag: Any?)
}