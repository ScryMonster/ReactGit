package com.example.fox.reactgit.utils.ext

import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.base.IBaseView
import com.example.fox.reactgit.arch.ui.base.IProgressView
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.TimeoutCancellationException
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withTimeout
import java.net.UnknownHostException


fun <V : IProgressView> BasePresenter<V>.launchWithProgress(block: suspend V.() -> Unit,
                                                            error: suspend V.(Exception) -> Unit) {

    launch(UI + parentJob) {

        try {
            withProgress {
                block(getView())
            }
        } catch (e: Exception) {
            commonErrorHandler(e,e.localizedMessage ?: "some error") {
                error(getView(), e)
            }
        }
        finally {
            getView().apply {
                hideProgress(null)
                switchOffUiInteraction(false)
            }
        }

    }
}


fun <V : IBaseView> BasePresenter<V>.launchUI(block: suspend V.() -> Unit,
                                              errorHandler: suspend V.() -> Unit = {},
                                              errorMessage: String = "") {
    launch(UI + parentJob) {
        try {
            block(getView())
        } catch (e: Exception) {
            e.printStackTrace()
            if (errorMessage == "") {
                commonErrorHandler(e,e.localizedMessage) {
                    errorHandler(getView())
                }
            } else commonErrorHandler(e,errorMessage) {
                errorHandler(getView())
            }


        }

    }
}


suspend fun <V : IProgressView> BasePresenter<V>.withProgress(code: suspend V.() -> Unit) {
    getView().apply {
        showProgress(null)
        switchOffUiInteraction(true)
    }
    code(getView())
    getView().apply {
        hideProgress(null)
        switchOffUiInteraction(false)
    }
}

suspend fun <V : IBaseView> BasePresenter<V>.commonErrorHandler(e:Exception,error: String, code: suspend V.() -> Unit = {}) {
    when(e){
        is UnknownHostException -> getView().errorMessage("Connection Lost")
        else -> getView().errorMessage(error)
    }
    code(getView())

}


fun <T> Deferred<T>.launchCoroutine(success: suspend (T) -> Unit,
                                    error: suspend (Exception) -> Unit) {

    launch(UI) {
        try {
            val value = this@launchCoroutine.await()
            success(value)
        } catch (e: Exception) {
            error(e)
        }
    }
}


fun tryTimeOut(time:Int,toDo:suspend ()->Unit,after:suspend ()->Unit) = launch {
    try {
        withTimeout(time) {
            toDo()
        }
    }catch (e:TimeoutCancellationException){
        after()
    }

}







