package com.example.fox.reactgit.arch.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.example.fox.reactgit.R
import com.example.fox.reactgit.application.ReactGit
import com.example.fox.reactgit.utils.inflate
import com.example.fox.reactgit.utils.showInSnackBarIn
import com.example.fox.reactgit.utils.showInSnackBarInError
import com.victor.loading.rotate.RotateLoading

abstract class BaseFragment : Fragment(),IBaseView{

    protected val manager by lazy {
        (activity?.application as ReactGit).manager
    }
    private lateinit var progress: RotateLoading
    private var saved = false



    abstract fun setView(): Int

    abstract override fun buildGraph()

    abstract override fun destroyGraph()

    abstract override fun init()




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = container?.inflate(setView())
        progress = view?.findViewById(R.id.rotateLoading)!!
        return view
    }

    override fun makeBackgroundVisibleWhileProgrees(flag: Boolean) {
        fun switchOffInteractionWithUi() {
            activity?.window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
        fun switchOnInteractionWWithUI(){
            activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }

        if (flag) switchOnInteractionWWithUI()
        else switchOffInteractionWithUi()
    }



    override fun onDestroy() {
        super.onDestroy()
        if (!saved) destroyGraph()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saved = true
    }

    override fun showProgress(tag: Any?) {
        progress.start()
    }

    override fun hideProgress(tag: Any?) {
        progress.stop()
    }

    override fun infoMessage(message: String) {
        message.showInSnackBarIn(view!!)
    }

    override fun errorMessage(message: String) {
        message.showInSnackBarInError(view!!)
    }

    override fun infoMessage(message: Int) {
       resources.getString(message).showInSnackBarIn(view!!)
    }

    override fun errorMessage(message: Int) {
        resources.getString(message).showInSnackBarIn(view!!)
    }
}