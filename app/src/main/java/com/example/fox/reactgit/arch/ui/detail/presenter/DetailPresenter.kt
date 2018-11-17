package com.example.fox.reactgit.arch.ui.detail.presenter

import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.detail.view.IDetailView
import javax.inject.Inject
import com.example.fox.reactgit.di.scopes.DetailScope as Detail

@Detail
class DetailPresenter @Inject constructor() : IDetailPresenter, BasePresenter<IDetailView>(){
    override fun init() {
        getView()?.setList()
    }




}