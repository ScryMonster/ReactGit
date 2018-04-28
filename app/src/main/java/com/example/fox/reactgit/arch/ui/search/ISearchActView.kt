package com.example.fox.reactgit.arch.ui.search

import com.example.fox.reactgit.arch.ui.base.IBaseView
import com.example.fox.reactgit.dto.Repository

interface ISearchActView : IBaseView{
    fun checkInternetConnection() : Boolean
    fun innerFragmentNavigation(key:String,list: List<Repository>)
}