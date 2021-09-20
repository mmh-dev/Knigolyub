package com.mmh.knigolyub

import android.app.Application

//import com.parse.Parse


class App : Application() {
    override fun onCreate() {
        super.onCreate()
//        Parse.initialize(Parse.Configuration.Builder(this)
//                .applicationId(getString(R.string.applicationID))
//                .clientKey(getString(R.string.clientKey))
//                .server(getString(R.string.ParseAPI))
//                .build()
//        )
    }
}