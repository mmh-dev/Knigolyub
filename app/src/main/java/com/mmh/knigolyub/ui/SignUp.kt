package com.mmh.knigolyub.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mmh.knigolyub.databinding.ActivitySignUpBinding
import com.thekhaeng.pushdownanim.PushDownAnim

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            PushDownAnim.setPushDownAnimTo(teacherBtn)
                .setOnClickListener {
                    startActivity(Intent(this@SignUp, SignUpTeacher::class.java))
                }
            PushDownAnim.setPushDownAnimTo(studentBtn)
                .setOnClickListener {
                    startActivity(Intent(this@SignUp, SignUpStudent::class.java))
                }
            signInLink.setOnClickListener {
                startActivity(Intent(this@SignUp, Login::class.java))
            }
        }
    }
}