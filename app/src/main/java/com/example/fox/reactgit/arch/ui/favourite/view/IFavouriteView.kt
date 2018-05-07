package com.example.fox.reactgit.arch.ui.favourite.view

import com.example.fox.reactgit.arch.ui.base.IBaseView
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User

interface IFavouriteView : IBaseView{
    fun setList(list: List<User>)
    fun replacment(repositories:List<Repository>)

}