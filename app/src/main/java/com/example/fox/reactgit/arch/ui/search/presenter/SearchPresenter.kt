package com.example.fox.reactgit.arch.ui.search.presenter

import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.search.view.ISearchView
import com.example.fox.reactgit.di.scopes.SearchScope
import javax.inject.Inject

@SearchScope
class SearchPresenter @Inject constructor() : BasePresenter<ISearchView>(),ISearchPresenter {
    override fun init() {

    }

}