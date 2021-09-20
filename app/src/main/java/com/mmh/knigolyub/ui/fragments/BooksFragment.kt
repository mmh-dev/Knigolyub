package com.mmh.knigolyub.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.mmh.knigolyub.databinding.FragmentBooksBinding
import com.mmh.knigolyub.entities.User
import com.mmh.knigolyub.viewmodel.UserViewModel
import kotlinx.coroutines.launch


class BooksFragment : Fragment() {

    private lateinit var binding: FragmentBooksBinding
    private val viewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBooksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = User(
            name = "kjkkjk",
            password = "lklkll",
            email = "mmh@tyhrt.ru",
            school = "ili",
            grade = 6,
            gradeLetter = "альфа",
            isMale = true,
            phone = 555973025,
            status = "teacher"
        )

        lifecycleScope.launch {
            viewModel.insertUser(user)
        }
    }

}