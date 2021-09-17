package com.mmh.knigolyub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.mmh.knigolyub.databinding.ActivityLoginBinding
import com.mmh.knigolyub.databinding.ActivityMainBinding
import com.mmh.knigolyub.utils.showToast
import com.thekhaeng.pushdownanim.PushDownAnim

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        PushDownAnim.setPushDownAnimTo(binding.signInBtn)
            .setOnClickListener {
                showToast("shfegr")
            }


    }
}