package com.mmh.knigolyub.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mmh.knigolyub.entities.Book
import com.mmh.knigolyub.ui.activities.MainActivity
import io.realm.RealmModel
import io.realm.RealmResults


class BookViewModel : ViewModel() {

    //    fun getAllBooks(): LiveData<List<Book>> {
//        val allBooks: LiveData<List<Book>>()
//        MainActivity.userRealm?.executeTransactionAsync{
//            val results = it
//                .where<Book>()
//                .findAll()
//            allBooks.addAll(it.copyFromRealm(results))
//            Log.i("tag", allBooks.size.toString())
//        }
//        return allBooks
//    }
    fun <T : RealmModel> RealmResults<T>.asLiveData() = RealmLiveData<T>(this)

    fun getBooksLiveData(): LiveData<RealmResults<Book>> {
        return MainActivity.userRealm?.where<Book>()?.findAllAsync()
    }

    fun getBooksWithFilter(param: String, value: String): List<Book> {
        val books = mutableListOf<Book>()
        MainActivity.userRealm?.executeTransactionAsync {
            val allBooks = it
                .where<Book>()
                .equalTo(param, value)
                .findAll()
        }
        return books
    }

    fun addNewBook(book: Book) {
        MainActivity.userRealm?.executeTransactionAsync {
            it.insert(book)
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