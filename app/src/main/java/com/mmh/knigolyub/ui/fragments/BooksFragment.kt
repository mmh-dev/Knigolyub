package com.mmh.knigolyub.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmh.knigolyub.adapters.BooksAdapter
import com.mmh.knigolyub.databinding.FragmentBooksBinding
import com.mmh.knigolyub.entities.Book
import com.mmh.knigolyub.viewmodel.BookViewModel
import com.mmh.knigolyub.viewmodel.UserViewModel


class BooksFragment : Fragment() {

    private lateinit var binding: FragmentBooksBinding
    private val bookViewModel: BookViewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()
    private var booksAdapter = BooksAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBooksBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBooksList()

        binding.findBtn.setOnClickListener {
            val book = Book()
            book.title = "Tom and Finn"
            book.author = "Mark Twain"
            book.numberOfPages = "300"
            bookViewModel.addNewBook(book)
        }
    }

    private fun getBooksList() {
        bookViewModel.getAllBooks()
        binding.apply {
            bookListView.apply {
                adapter = booksAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

        }
        bookViewModel.booksLiveData.observe(viewLifecycleOwner) {
            booksAdapter.submitList(it)
            Log.i("tag", it.size.toString())
        }
    }
}