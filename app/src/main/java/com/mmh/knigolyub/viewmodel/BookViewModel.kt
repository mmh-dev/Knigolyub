package com.mmh.knigolyub.viewmodel

import androidx.lifecycle.ViewModel
import com.mmh.knigolyub.entities.Book
import com.mmh.knigolyub.entities.Chapter
import com.mmh.knigolyub.ui.activities.MainActivity
import io.realm.kotlin.where


class BookViewModel : ViewModel() {


    fun getAllBooks(): List<Book> {
        val books = mutableListOf<Book>()
        val results = MainActivity.userRealm?.where<Book>()
            ?.findAll()
        MainActivity.userRealm?.copyFromRealm(results)?.let { books.addAll(it) }
        return books
    }

    fun getBookWithTitleAndAuthor(title: String, author: String): Book? {
        return MainActivity.userRealm?.where<Book>()
            ?.contains("title", title)
            ?.contains("author", author)
            ?.findFirst()
    }

    fun getBookOfReader(readerId: String): List<Book> {
        val books = mutableListOf<Book>()
        val results = MainActivity.userRealm?.where<Book>()
            ?.contains("readerId", readerId)
            ?.findAll()
        MainActivity.userRealm?.copyFromRealm(results)?.let { books.addAll(it) }
        return books
    }

    fun getChaptersOfBook(school: String, bookId: String): List<Chapter> {
        val chapters = mutableListOf<Chapter>()
        val results = MainActivity.userRealm?.where<Book>()
            ?.contains("school", school)
            ?.contains("bookId", bookId)
            ?.findAll()
        MainActivity.userRealm?.copyFromRealm(results)?.let { chapters.addAll(it) }
        return chapters
    }

    fun addNewBook(book: Book) {
        MainActivity.userRealm?.executeTransactionAsync {
            it.insert(book)
        }
    }

    fun addNewChapter(chapter: Chapter) {
        MainActivity.userRealm?.executeTransactionAsync {
            it.insert(chapter)
        }
    }

    fun updateBook(param: String, oldValue: String, newValue: String) {
        MainActivity.userRealm?.executeTransactionAsync {
            val book: Book = it
                .where<Book>()
                .equalTo(param, oldValue)
                .findFirst()!!
            it.insertOrUpdate(changeBookParam(book, param, newValue))
        }
    }

    fun deleteBook(param: String, value: String) {
        MainActivity.userRealm?.executeTransactionAsync {
            val book = it
                .where<Book>()
                .equalTo(param, value)
                .findFirst()
            book?.deleteFromRealm()
        }
    }

    private fun changeBookParam(book: Book, param: String, newValue: String): Book {
        when (param) {
            "title" -> {
                book.title = newValue
            }
            "author" -> {
                book.author = newValue
            }
            "publishYear" -> {
                book.publishYear = newValue
            }
            "numberOfPages" -> {
                book.numberOfPages = newValue
            }
            "progress" -> {
                book.progress = newValue
            }
            "readerId" -> {
                book.readerId = newValue
            }
        }
        return book
    }
}