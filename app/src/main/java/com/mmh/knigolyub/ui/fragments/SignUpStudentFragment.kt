package com.mmh.knigolyub.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mmh.knigolyub.R
import com.mmh.knigolyub.databinding.FragmentSignUpStudentBinding
import com.mmh.knigolyub.entities.User
import com.mmh.knigolyub.utils.showToast
import com.mmh.knigolyub.utils.transactionOperation
import com.mmh.knigolyub.viewmodel.UserViewModel
import com.thekhaeng.pushdownanim.PushDownAnim
import java.util.*


class SignUpStudentFragment : Fragment() {

    private lateinit var binding: FragmentSignUpStudentBinding
    private val userViewModel: UserViewModel by activityViewModels()
    private var student = User()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpStudentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val schools = resources.getStringArray(R.array.schools)
        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, schools)
        binding.schoolSpinner.adapter = adapter

        binding.apply {
            PushDownAnim.setPushDownAnimTo(signUpBtn)
                .setOnClickListener {
                    schoolSpinner.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?, view: View?, position: Int, id: Long
                            ) {
                                student.school = schools[position].toString()
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                            }
                        }
                    student.lastName = lastNameField.text.toString()
                    student.firstName = firstNameField.text.toString()
                    student.password = passwordField.text.toString()
                    student.email = emailField.text.toString()
                    student.grade = gradeField.text.toString()
                    student.gradeLetter = gradeLetterField.text.toString()
                    student.phone = phoneField.text.toString()
                    student.status = "student"
                    student.joinedAt = Date()
                    radioGroup.setOnCheckedChangeListener { group, checkedId ->
                        val radio: RadioButton = group.findViewById(checkedId)
                        student.gender = radio.text.toString()
                    }
                    userViewModel.addNewReader(student)
                    showToast("Читатель ${student.firstName} ${student.lastName} успешно зарегистрирован!")
                }
            signInLink.setOnClickListener {
                transactionOperation(LoginFragment())
            }
        }
    }
}