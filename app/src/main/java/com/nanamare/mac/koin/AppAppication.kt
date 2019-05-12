package com.nanamare.mac.koin

import android.app.Application
import com.nanamare.mac.koin.di.appModules
import org.koin.android.ext.android.startKoin

class AppAppication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, appModules)
    }

}


