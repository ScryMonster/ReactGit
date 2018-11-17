package com.example.fox.reactgit.arch.ui.base.rv

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View


abstract class BaseViewHolder<in Item>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: Item, position: Int)

}