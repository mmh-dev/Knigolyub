package com.mmh.domain.repository

import com.mmh.domain.Resource
import com.mmh.domain.models.AddNewBookThatReadDomain
import com.mmh.domain.models.BookThatReadDomain
import kotlinx.coroutines.flow.Flow


interface BookThatReadRepository {

    fun fetchMyBooks(id: String): Flow<Resource<List<BookThatReadDomain>>>

    fun onRefresh(id: String): Flow<Resource<List<BookThatReadDomain>>>

    fun fetchStudentBooks(id: String): Flow<Resource<List<BookThatReadDomain>>>

    fun fetchMyBook(id: String, userId: String): Flow<Resource<Int>>

    fun deleteMyBook(id: String): Flow<Resource<Unit>>

    fun addBook(book: AddNewBookThatReadDomain): Flow<Resource<Unit>>

    fun updateProgress(id: String, progress: Int): Flow<Resource<Unit>>

    fun updateChapters(
        id: String,
        chapters: Int,
        isReadingPages: List<Boolean>,
    ): Flow<Resource<Unit>>

    fun fetchUsersBooks(id: String): Flow<Resource<List<BookThatReadDomain>>>

    suspend fun clearBooksCache()

}