package com.mmh.knigolyub

import android.app.Application
import androidx.room.Room
import com.mmh.knigolyub.db.AppDatabase

//import com.parse.Parse

const val DB_NAME = "myDb.db"
lateinit var instance: AppDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
//        Parse.initialize(Parse.Configuration.Builder(this)
//                .applicationId(getString(R.string.applicationID))
//                .clientKey(getString(R.string.clientKey))
//                .server(getString(R.string.ParseAPI))
//                .build()
//        )


        instance = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            DB_NAME
        ).build()

    }
}