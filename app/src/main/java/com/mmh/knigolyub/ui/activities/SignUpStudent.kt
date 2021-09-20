package com.mmh.knigolyub.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mmh.knigolyub.databinding.ActivitySignUpStudentBinding
import com.mmh.knigolyub.utils.showToast
import com.thekhaeng.pushdownanim.PushDownAnim

class SignUpStudent : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            PushDownAnim.setPushDownAnimTo(signUpBtn)
                .setOnClickListener {
                    showToast("shfegr")
                }
            signInLink.setOnClickListener {
                startActivity(Intent(this@SignUpStudent, SignUp::class.java))
            }
        }
    }
}