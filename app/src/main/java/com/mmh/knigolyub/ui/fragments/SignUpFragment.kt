package com.mmh.knigolyub.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mmh.knigolyub.databinding.FragmentSignUpBinding
import com.mmh.knigolyub.utils.transactionOperation
import com.thekhaeng.pushdownanim.PushDownAnim

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            PushDownAnim.setPushDownAnimTo(teacherBtn)
                .setOnClickListener {
                    transactionOperation(SignUpTeacherFragment())
                }
            PushDownAnim.setPushDownAnimTo(studentBtn)
                .setOnClickListener {
                    transactionOperation(SignUpStudentFragment())
                }
            signInLink.setOnClickListener {
                transactionOperation(LoginFragment())
            }
        }
    }
}