package com.nanamare.mac.koin.presenter

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<BaseInterface> {

    protected var compositeDisposable: CompositeDisposable? = null

    var baseInterface: BaseInterface? = null
        set(value) {
            if (this.baseInterface !== value) {
                field = value
                compositeDisposable = CompositeDisposable()
            }
        }


    fun dropBaseInterface(baseInterface: BaseInterface) {
        if (baseInterface == null) {
            throw NullPointerException("dropped baseInterface must not be null")
        }
        if (baseInterface === this.baseInterface) {
            compositeDisposable?.clear()
            this.baseInterface = null
        }
    }

    protected fun hasBaseInterface(): Boolean {
        return baseInterface != null
    }


}
