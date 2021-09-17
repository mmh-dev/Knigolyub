package com.mmh.knigolyub.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mmh.knigolyub.R
import com.mmh.knigolyub.databinding.ActivityMainBinding
import com.mmh.knigolyub.databinding.ActivitySignUpBinding
import com.mmh.knigolyub.utils.showToast
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
                    startActivity(Intent(this@SignUp, SignUpTeacher1::class.java))
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