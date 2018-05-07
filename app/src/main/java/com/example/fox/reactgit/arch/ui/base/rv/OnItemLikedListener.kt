package com.example.fox.reactgit.arch.ui.base.rv

import com.like.OnLikeListener

interface OnItemLikedListener <T> : OnLikeListener{
    fun like(item:T)
}