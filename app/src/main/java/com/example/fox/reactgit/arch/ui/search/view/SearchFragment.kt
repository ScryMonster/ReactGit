package com.example.fox.reactgit.arch.ui.search.view

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.adapters.SearchRvAdapter
import com.example.fox.reactgit.arch.ui.base.BaseFragment
import com.example.fox.reactgit.arch.ui.base.rv.OnItemClickListener
import com.example.fox.reactgit.arch.ui.search.SearchActivity
import com.example.fox.reactgit.arch.ui.search.presenter.SearchPresenter
import com.example.fox.reactgit.di.components.SearchActivityComponent
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.Constants
import com.example.fox.reactgit.utils.Constants.FragmentNames.DETAIL_FRAGMENT
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject

class SearchFragment @Inject constructor() : BaseFragment(),ISearchView {

    @Inject lateinit var presenter:SearchPresenter
    @Inject lateinit var adapter:SearchRvAdapter


    override fun setView() = R.layout.fragment_search

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildGraph()
        presenter.run {
            attach(this@SearchFragment)
            validateField(RxTextView.textChanges(git_search))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detach()
    }

    override fun buildGraph() {
        manager.addSearcFragmentComponent().inject(this)
    }

    override fun destroyGraph() {
        manager.removeSearchhFragmentComponent()
    }

    override fun init() {}


    override fun startSearching(searchTerms: String) {
        presenter.searchGitUser(searchTerms)
    }

    override fun replacment(repositories: List<Repository>) {
        (activity as SearchActivity).innerFragmentNavigation(DETAIL_FRAGMENT,repositories)
    }

    override fun setList(list: List<User>) {
        adapter.run {
            setListener(object : OnItemClickListener<User>{
                override fun onItemClick(item: User) {
                    presenter.getUserRepositories(item.login)
                }

            })
            setItems(list,true)
        }
        git_rv.adapter = adapter
        git_rv.layoutManager = LinearLayoutManager(context)
    }

}