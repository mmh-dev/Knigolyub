package com.mmh.knigolyub.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mmh.knigolyub.entities.Book
import com.mmh.knigolyub.entities.User

@Database(entities = [User::class, Book::class], version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun Dao(): Dao
}