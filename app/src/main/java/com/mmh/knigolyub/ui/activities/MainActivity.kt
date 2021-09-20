package com.mmh.knigolyub.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mmh.knigolyub.R
import com.mmh.knigolyub.databinding.ActivityMainBinding
import com.mmh.knigolyub.ui.fragments.BooksFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, BooksFragment())
                .commit()
        }
    }
}