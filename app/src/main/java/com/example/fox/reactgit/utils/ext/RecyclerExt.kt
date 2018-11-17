package com.example.fox.reactgit.utils.ext

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.fox.reactgit.arch.ui.base.rv.BaseAdapter
import com.example.fox.reactgit.arch.ui.base.rv.BaseViewHolder
import com.example.fox.reactgit.arch.ui.base.rv.OnItemClickedListener

fun<VH : BaseViewHolder<Item>,Item> RecyclerView.buildWithAction(adapter: BaseAdapter<Item,VH>, code:(Item) -> Unit){
    this.adapter = adapter
    layoutManager = LinearLayoutManager(context)
    itemAnimator = DefaultItemAnimator()
    adapter.setListener(object : OnItemClickedListener<Item> {
        override fun onItemClick(item: Item, position: Int) {
            code(item)
        }
    })
}

infix fun<VH : BaseViewHolder<Item>,Item> RecyclerView.setUPAdapter(adapter: BaseAdapter<Item,VH>){
    this.adapter = adapter
    layoutManager = LinearLayoutManager(context)
    itemAnimator = DefaultItemAnimator()
}


fun RecyclerView.setUP(){
    layoutManager = LinearLayoutManager(context)
    itemAnimator = DefaultItemAnimator()
}