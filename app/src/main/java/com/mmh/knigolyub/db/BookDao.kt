package com.mmh.knigolyub.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mmh.knigolyub.entities.Book

@Dao
interface BookDao {

    @Query("SELECT * FROM books")
    fun getAllBooksLiveData(): LiveData<List<Book>>

    @Query("SELECT * FROM books WHERE bookId LIKE :bookId")
    suspend fun getBook(bookId: Int): Book

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBook(book: Book)

    @Query("DELETE FROM books")
    suspend fun clearBooks()

}