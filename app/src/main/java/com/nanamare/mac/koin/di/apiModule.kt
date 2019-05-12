package com.nanamare.mac.koin.di

import com.nanamare.mac.koin.Api
import com.nanamare.mac.koin.presenter.PhotoPresenter
import com.nanamare.mac.koin.presenter.PhotoPresenterImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

// Singletone 으로 App 에서 전역적으로 하나만 존재
private val apiModule = module {
    single {
        Retrofit.Builder()
                .client(OkHttpClient.Builder().build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getProperty<String>("BASE_URL"))
                .build()
                .create(Api::class.java)
    }
}

// inject 하는 순간 객체 생성 (항상 lazy init 임 성능상에 이점이 있)
val photoListModule: Module = module {
    factory {
        PhotoPresenterImpl(get()) as PhotoPresenter
    }
}

val appModules = listOf(apiModule, photoListModule)