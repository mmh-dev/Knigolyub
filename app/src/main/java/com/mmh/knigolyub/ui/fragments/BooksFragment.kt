package com.mmh.knigolyub.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mmh.knigolyub.databinding.FragmentBooksBinding
import com.mmh.knigolyub.entities.Book
import com.mmh.knigolyub.ui.activities.MainActivity
import com.mmh.knigolyub.viewmodel.BookViewModel
import com.mmh.knigolyub.viewmodel.UserViewModel
import io.realm.kotlin.where


class BooksFragment : Fragment() {

    private lateinit var binding: FragmentBooksBinding
    private val bookViewModel: BookViewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBooksBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.findBtn.setOnClickListener {
//            deleteBook()
            val allBooks = bookViewModel.getAllBooks()
            Log.i("tag", allBooks.size.toString())
            for (book in allBooks) {
                Log.i("tag", book.author.toString())
            }
        }
    }

    private fun deleteBook() {
        MainActivity.userRealm?.executeTransactionAsync {
            val book = it.where<Book>()
                .equalTo("title", "new title")
                .findFirst()
            book?.deleteFromRealm() // здесь производится удаление объекта
        }
    }
}