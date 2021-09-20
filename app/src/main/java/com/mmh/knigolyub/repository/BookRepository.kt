package com.mmh.knigolyub.repository

import com.mmh.knigolyub.entities.Book
import com.mmh.knigolyub.instance

object BookRepository {
    private val dao = instance.Dao()

    fun getAllBooksLiveData() = dao.getAllBooksLiveData()

    suspend fun getBook(bookId: Int) = dao.getBook(bookId)

    suspend fun updateBook(book: Book) = dao.updateBook(book)

    suspend fun clearBooks() = dao.clearBooks()

}