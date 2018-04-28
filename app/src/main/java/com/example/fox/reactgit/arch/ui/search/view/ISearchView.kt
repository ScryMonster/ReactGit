package com.example.fox.reactgit.arch.ui.search.view

import com.example.fox.reactgit.arch.ui.base.IBaseView
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User

interface ISearchView : IBaseView {
    fun setList(list:List<User>)
    fun startSearching(searchTerms:String)
    fun replacment(repositories:List<Repository>)
}