package com.mmh.knigolyub

import android.app.Application
import android.util.Log
import com.mmh.knigolyub.utils.MONGODB_APP_ID
import io.realm.Realm
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration

lateinit var app: App

inline fun <reified T> T.TAG(): String = T::class.java.simpleName

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        app = App(
            AppConfiguration.Builder(MONGODB_APP_ID)
                .defaultSyncErrorHandler { session, error ->
                    Log.e(TAG(), "Sync error: ${error.errorMessage}")
                }
                .build()
        )
    }
}