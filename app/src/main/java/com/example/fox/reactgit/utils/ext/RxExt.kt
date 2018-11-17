package com.example.fox.reactgit.utils.ext

import com.example.fox.reactgit.arch.ui.base.IBaseView
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun Disposable.addTo(compositeDisposable: CompositeDisposable): Disposable {
    compositeDisposable.add(this)
    return this
}

fun <T> Single<T>.applySchedulers() =
        observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())

fun <T> Observable<T>.applySchedulers() =
        observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())

fun <T> Single<T>.showProgress(view: IBaseView) = this
        .doOnSubscribe {
            view.showProgress(null)
            view.switchOffUiInteraction(false)
        }
        .doFinally {
            view.hideProgress(null)
            view.switchOffUiInteraction(true)
        }!!