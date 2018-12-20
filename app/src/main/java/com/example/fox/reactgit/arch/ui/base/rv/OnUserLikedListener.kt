package com.example.fox.reactgit.arch.ui.base.rv

import com.example.fox.reactgit.dto.User
import com.like.LikeButton
import com.like.OnLikeListener

interface OnUserLikedListener : OnLikeListener{
    fun like(item:User)
    override fun liked(p0: LikeButton?) {}
    override fun unLiked(p0: LikeButton?) {}
}