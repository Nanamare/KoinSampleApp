package com.nanamare.mac.koin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageView
import android.util.Log
import com.bumptech.glide.Glide
import com.nanamare.mac.koin.R
import com.nanamare.mac.koin.model.Photo
import com.nanamare.mac.koin.presenter.PhotoPresenter
import com.nanamare.mac.koin.presenter.PhotoScene
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), PhotoScene {

    companion object{
        @JvmStatic
        val TAG: String = MainActivity::class.java.simpleName
    }

    private val presenter: PhotoPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.baseInterface = this
        presenter.requestPhoto(1)

    }

    override fun onLoadPhoto(photo: Photo) {
        val mainIv = findViewById<AppCompatImageView>(R.id.activity_main_iv)

        Glide.with(this)
                .load(photo.thumbnailUrl)
                .into(mainIv)

    }

    override fun onLoadFail(error: String?) {
        Log.d(TAG, error)
    }

}
