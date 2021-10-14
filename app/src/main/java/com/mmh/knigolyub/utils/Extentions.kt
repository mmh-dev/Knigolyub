package com.mmh.knigolyub.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.mmh.knigolyub.R

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Fragment.transactionOperation(fragment: Fragment) {
    val transaction = fragmentManager?.beginTransaction()
    transaction?.replace(R.id.fragmentContainer, fragment)
    transaction?.commit()
}

fun FragmentActivity.transactionOperation(fragment: Fragment) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.fragmentContainer, fragment)
    transaction.commit()
}

/*
private fun queryAllBooks() {
    MainActivity.userRealm?.executeTransactionAsync {
        val allBooks: RealmResults<Book> = it
            .where<Book>()!!
            .findAll()
        for (book in allBooks) {
            Log.i("tag1", book.author.toString())
        }
    }
}

private fun queryBooksWithFilter() {
    MainActivity.userRealm?.executeTransactionAsync {
        val allBooks: RealmResults<Book> = it
            .equalTo("author", "The game")
            .findAll()
        for (book in allBooks) {
            Log.i("tag1", book.author.toString())
        }
    }
}

private fun queryBooksWithTwoFilter() {
    MainActivity.userRealm?.executeTransactionAsync {
        val allBooks: RealmResults<Book> = it
            .equalTo("author", "The game")
            .equalTo("title", "second title")
            .findAll()
        for (book in allBooks) {
            Log.i("tag1", book.author.toString())
        }
    }
}

private fun addNewBook() {
        val book = Book()
        book.author = "The game"
        book.title = "second title"
        MainActivity.userRealm?.executeTransactionAsync({
            it.insert(book)
        }, { // добавь действие при успехе транзакции
            Log.i("tag1", "created book")
        }, {  // добавь действие при неудаче транзакции
            Log.i("tag1", "Failed transaction")
        })
    }


 */


