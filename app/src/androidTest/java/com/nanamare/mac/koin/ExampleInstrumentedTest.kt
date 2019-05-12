package com.nanamare.mac.koin

import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.nanamare.mac.koin.di.appModules
import com.nanamare.mac.koin.model.Photo
import com.nanamare.mac.koin.presenter.PhotoPresenter
import com.nanamare.mac.koin.presenter.PhotoScene
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest : AutoCloseKoinTest(), PhotoScene {

    companion object{
        @JvmStatic
        val TAG: String = ExampleInstrumentedTest::class.java.simpleName
    }

    private val presenter: PhotoPresenter by inject()

    @Before
    fun 초기화() {
        startKoin{
            modules(appModules)
        }
    }

    @Test
    fun Mock_테스트() {
        // Context of the app under test.

        presenter.baseInterface = this
        presenter.requestPhoto(1)

    }

    override fun onLoadFail(error: String?) {
        Log.d(TAG, error)
    }

    override fun onLoadPhoto(photo: Photo) {
        assertNotNull(photo)
        Log.d(TAG, photo.thumbnailUrl)
    }

}
