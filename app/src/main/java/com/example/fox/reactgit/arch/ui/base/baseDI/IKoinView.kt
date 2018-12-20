package com.example.fox.reactgit.arch.ui.base.baseDI

import org.koin.core.KoinContext

interface IKoinView {
    val scopeName:String
    val koin:KoinContext
    fun buildKoinScope()
    fun destroyKoinScope()

}