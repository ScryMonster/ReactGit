package com.example.fox.reactgit.arch.ui.base.rv

import android.view.View


interface OnItemClickedListener<Item> {

    fun onItemClick(item: Item,position:Int)

}