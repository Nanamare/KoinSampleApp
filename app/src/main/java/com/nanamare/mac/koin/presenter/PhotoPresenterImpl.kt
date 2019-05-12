package com.nanamare.mac.koin.presenter

import com.nanamare.mac.koin.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

    class PhotoPresenterImpl(private val api: Api): PhotoPresenter() {
    override fun requestPhoto(id: Long) {
        compositeDisposable?.add(api.getPhoto(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    baseInterface?.onLoadPhoto(it)
                }, {
                    baseInterface?.onLoadFail(it.toString())
                })
        )
    }
}