package com.mmh.knigolyub.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mmh.knigolyub.databinding.FragmentBooksBinding
import com.mmh.knigolyub.utils.showToast
import com.mmh.knigolyub.viewmodel.BookViewModel
import com.mmh.knigolyub.viewmodel.UserViewModel


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

            val book = bookViewModel.getBookWithTitleAndAuthor("Tom and Finn", "Marco Polo")
            showToast(book?.author.toString())
        }
    }
}