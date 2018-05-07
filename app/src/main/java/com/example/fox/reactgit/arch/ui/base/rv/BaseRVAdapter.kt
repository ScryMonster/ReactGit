package com.example.fox.reactgit.arch.ui.base.rv

import android.support.v7.widget.RecyclerView

abstract class BaseRVAdapter<T,VH:BaseRecyclerViewHolder<T>>  : RecyclerView.Adapter<VH>(){

    protected val list = arrayListOf<T>()
    protected lateinit var click:OnItemClickListener<T>

    fun setList(list:List<T>,notify:Boolean = false){
        this.list.addAll(list)
        if (notify) notifyDataSetChanged()
    }



    fun setClickListener(listener:OnItemClickListener<T>){
        click = listener
    }
}