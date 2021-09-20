package com.mmh.knigolyub.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mmh.knigolyub.entities.User

@Database(entities = [User::class], version = 1)

abstract class UserDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao

    companion object {
        private const val DB_NAME_USERS = "users_db.db"
        private lateinit var db_users: UserDatabase


        fun init(context: Context) {
            db_users = Room.databaseBuilder(
                context,
                UserDatabase::class.java,
                DB_NAME_USERS
            ).build()
        }
    }

}