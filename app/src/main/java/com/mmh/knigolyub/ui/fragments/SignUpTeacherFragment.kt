package com.mmh.knigolyub.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mmh.knigolyub.databinding.FragmentSignUpTeacherBinding
import com.mmh.knigolyub.entities.User
import com.mmh.knigolyub.viewmodel.UserViewModel

class SignUpTeacherFragment : Fragment() {
    private lateinit var binding: FragmentSignUpTeacherBinding
    private val userViewModel: UserViewModel by activityViewModels()
    private var student = User()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpTeacherBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}