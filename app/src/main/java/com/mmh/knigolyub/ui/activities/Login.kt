package com.mmh.knigolyub.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mmh.knigolyub.databinding.ActivityLoginBinding
import com.mmh.knigolyub.utils.showToast
import com.thekhaeng.pushdownanim.PushDownAnim

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            PushDownAnim.setPushDownAnimTo(signInBtn)
                .setOnClickListener {
                    showToast("shfegr")
                }
            signUpLink.setOnClickListener {
                startActivity(Intent(this@Login, SignUp::class.java))
            }
        }






    }
}