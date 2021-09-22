package com.mmh.knigolyub.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mmh.knigolyub.databinding.FragmentBooksBinding
import com.mmh.knigolyub.ui.activities.ReaderActivity
import com.mmh.knigolyub.viewmodel.UserViewModel


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

//        lifecycleScope.launch {
//            viewModel.clearUsers()
//        }

        binding.button.setOnClickListener {
            startActivity(Intent(requireActivity(), ReaderActivity::class.java))
        }
    }

}