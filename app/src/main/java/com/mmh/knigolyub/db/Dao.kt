package com.mmh.knigolyub.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.mmh.knigolyub.entities.Book
import com.mmh.knigolyub.entities.User
import com.mmh.knigolyub.entities.UserWithBooks

@Dao
interface Dao {

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE userId LIKE :userId")
    suspend fun getUser(userId: Int): User

    @Update
    suspend fun updateUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM users")
    suspend fun clearUsers()


    @Query("SELECT * FROM books")
    fun getAllBooksLiveData(): LiveData<List<Book>>

    @Query("SELECT * FROM books WHERE bookId LIKE :bookId")
    suspend fun getBook(bookId: Int): Book

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBook(book: Book)

    @Query("DELETE FROM books")
    suspend fun clearBooks()

    @Transaction
    @Query("SELECT * FROM users")
    suspend fun getUsersWithBooks(): List<UserWithBooks>

}