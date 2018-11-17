package com.example.fox.reactgit.arch.ui.search

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.example.fox.reactgit.R
import com.example.fox.reactgit.utils.enums.KoinScopes
import com.example.fox.reactgit.utils.ext.showErrorInSnackBar
import com.example.fox.reactgit.utils.ext.showInfoInSnackBar
import kotlinx.android.synthetic.main.activity_search.*
import org.koin.android.ext.android.getKoin
import org.koin.core.KoinContext
import org.koin.core.scope.Scope

class RootActivity : AppCompatActivity(),IRootView {


    override val scopeName: String  = KoinScopes.RootActivity.value

    override val koin: KoinContext = getKoin()

    private lateinit var session: Scope


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_search)
        buildKoinScope()
    }


    override fun init() {
        initListeners()
        initOther()
    }

    override fun infoMessage(message: String) {
        message showInfoInSnackBar  root
    }

    override fun infoMessage(message: Int) {
        message showInfoInSnackBar root
    }

    override fun errorMessage(message: String) {
        message showErrorInSnackBar root
    }

    override fun errorMessage(message: Int) {
        message showErrorInSnackBar root
    }

    override fun switchOffUiInteraction(flag: Boolean) {
        fun blockScreen() {
            window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }

        fun unBlockScreen() {
            window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
        if (flag) blockScreen()
        else unBlockScreen()
    }


    override fun buildKoinScope() {
        session = koin.createScope(scopeName)
    }

    override fun destroyKoinScope() {
        session.close()
    }


    private fun initListeners(){

    }
    private fun initOther(){

    }

    override fun openSearchFragment() {

    }

    override fun closeSearchFragment() {

    }

    override fun openFavouriteFragment() {

    }

    override fun closeFavouriteFragment() {

    }

    override fun openDetailFragment() {

    }

    override fun closeDetailFragment() {

    }



    override fun onDestroy() {
        super.onDestroy()
        destroyKoinScope()
    }
}