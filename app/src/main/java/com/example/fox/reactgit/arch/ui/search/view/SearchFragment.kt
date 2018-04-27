package com.example.fox.reactgit.arch.ui.search.view

import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.adapters.SearchRvAdapter
import com.example.fox.reactgit.arch.ui.base.BaseFragment
import com.example.fox.reactgit.arch.ui.search.presenter.SearchPresenter
import javax.inject.Inject

class SearchFragment @Inject constructor() : BaseFragment(),ISearchView {

    @Inject lateinit var presenter:SearchPresenter
    @Inject lateinit var adapter:SearchRvAdapter


    override fun setView() = R.layout.fragment_search

    override fun buildGraph() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroyGraph() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun init() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}