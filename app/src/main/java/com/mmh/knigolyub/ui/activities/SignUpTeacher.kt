package com.mmh.knigolyub.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mmh.knigolyub.databinding.ActivitySignUpTeacherBinding
import com.mmh.knigolyub.utils.showToast
import com.thekhaeng.pushdownanim.PushDownAnim

class SignUpTeacher : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpTeacherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpTeacherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            PushDownAnim.setPushDownAnimTo(signUpBtn)
                .setOnClickListener {
                    showToast("shfegr")
                }
            signInLink.setOnClickListener {
                startActivity(Intent(this@SignUpTeacher, SignUp::class.java))
            }
        }
    }
}