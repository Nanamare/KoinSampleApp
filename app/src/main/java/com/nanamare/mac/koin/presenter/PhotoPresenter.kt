package com.nanamare.mac.koin.presenter

abstract class PhotoPresenter : BasePresenter<PhotoScene>() {
    abstract fun requestPhoto(id : Long)
}
