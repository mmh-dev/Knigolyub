package com.mmh.knigolyub.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mmh.knigolyub.R
import com.mmh.knigolyub.databinding.ActivityReaderBinding
import com.mmh.knigolyub.ui.fragments.ReaderFragment

class ReaderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            transactionOperation(ReaderFragment())
        }
    }

    private fun transactionOperation(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}