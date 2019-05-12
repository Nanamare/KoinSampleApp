package com.nanamare.mac.koin

import com.nanamare.mac.koin.model.Photo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("photos/{id}")
    fun getPhoto(@Path("id") id: Long): Single<Photo>
}
