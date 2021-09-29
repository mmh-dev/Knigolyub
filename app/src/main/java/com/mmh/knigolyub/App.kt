package com.mmh.knigolyub

import android.app.Application
import androidx.room.Room
import com.mmh.knigolyub.db.AppDatabase
import io.realm.Realm
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration

const val DB_NAME = "myDb.db"
const val MONGODB_APP_ID = "knigolyub-mnlqi"
lateinit var instance: AppDatabase
lateinit var knigolyub: App

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        knigolyub = App(
            AppConfiguration.Builder(MONGODB_APP_ID)
                .build()
        )

        instance = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            DB_NAME
        ).build()

//        val email = "murod@mail.ru"
//        val password = "123456"
//
//        knigolyub.emailPassword.registerUserAsync(email, password, App.Callback {
//            if (it.isSuccess){
//                Log.i("tag", "create email")
//            }
//            else{
//                showToast("login failure")
//            }
//        })
//
//        knigolyub.loginAsync(Credentials.emailPassword(email, password), App.Callback {
//            if (it.isSuccess){
//                Log.i("tag", "email")
//            }
//            else{
//                showToast("login failure")
//            }
//        })

    }
}