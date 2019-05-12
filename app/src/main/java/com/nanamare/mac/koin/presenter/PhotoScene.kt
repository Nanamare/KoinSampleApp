package com.nanamare.mac.koin.presenter

import com.nanamare.mac.koin.model.Photo

interface PhotoScene: BaseInterface {
    fun onLoadPhoto(photo: Photo)
    fun onLoadFail(error: String?)
}