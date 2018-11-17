package com.example.fox.reactgit.arch.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.example.fox.reactgit.application.ReactGit
import com.example.fox.reactgit.arch.ui.search.RootActivity
import com.example.fox.reactgit.utils.ext.inflate
import com.example.fox.reactgit.utils.ext.showErrorInSnackBar
import com.example.fox.reactgit.utils.ext.showInfoInSnackBar

import org.koin.android.ext.android.getKoin
import org.koin.core.KoinContext
import org.koin.core.scope.Scope

abstract class BaseFragment : Fragment(),IBaseView,IKoinView{

    abstract val layoutId : Int
    abstract override val scopeName: String


    private lateinit var session: Scope

    private var saved = false

    protected val manager by lazy {
        (activity?.application as ReactGit).manager
    }
    protected val parent get() = activity as RootActivity?
    override val koin: KoinContext = getKoin()


    abstract override fun init()


    override fun buildKoinScope() {
        session = koin.createScope(scopeName)
    }

    override fun destroyKoinScope() {
        session.close()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =  container?.inflate(layoutId)

    override fun switchOffUiInteraction(flag: Boolean) {

        fun blockScreen(){
            parent?.window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
        fun unBlockScreen(){
            parent?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
        if (flag) blockScreen()
        else unBlockScreen()
    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saved = true
    }


    override fun infoMessage(message: String) {
        message.showInfoInSnackBar(view!!)
    }

    override fun errorMessage(message: String) {
        message.showErrorInSnackBar(view!!)
    }

    override fun infoMessage(message: Int) {
       resources.getString(message).showInfoInSnackBar(view!!)
    }

    override fun errorMessage(message: Int) {
        resources.getString(message).showErrorInSnackBar(view!!)
    }

}