package com.mmh.knigolyub

import android.app.Application
import com.mmh.knigolyub.utils.MONGODB_APP_ID
import io.realm.Realm
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration

lateinit var mongoDbAPp: App

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        mongoDbAPp = App(
            AppConfiguration.Builder(MONGODB_APP_ID)
                .build()
        )
    }
}