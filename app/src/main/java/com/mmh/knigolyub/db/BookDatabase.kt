package com.mmh.knigolyub.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mmh.knigolyub.entities.Book

@Database(entities = [Book::class], version = 1)

abstract class BookDatabase : RoomDatabase() {
    abstract fun BookDao(): BookDao

    companion object {
        private const val DB_NAME_BOOKS = "books_db.db"
        private lateinit var db_books: BookDatabase


        fun init(context: Context) {
            db_books = Room.databaseBuilder(
                context,
                BookDatabase::class.java,
                DB_NAME_BOOKS
            ).build()
        }
    }
}