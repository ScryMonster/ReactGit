package com.example.fox.reactgit.arch.ui.search

import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.di.scopes.SearchActivityScope as SearchActivity
import javax.inject.Inject

@SearchActivity
class SearchActivityPresenter @Inject constructor() : BasePresenter<ISearchActView>() {
    override fun init() {
        getMvpView()?.init()
    }

}