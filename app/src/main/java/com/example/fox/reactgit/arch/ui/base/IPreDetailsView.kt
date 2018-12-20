package com.example.fox.reactgit.arch.ui.base

import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User

interface IPreDetailsView {
    fun setList(list:List<User>)
    fun goInDetails(repositories:List<Repository>)
}