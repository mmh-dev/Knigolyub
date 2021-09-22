package com.mmh.knigolyub.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mmh.knigolyub.R
import com.mmh.knigolyub.databinding.ActivityMainBinding
import com.mmh.knigolyub.ui.fragments.BooksFragment
import com.mmh.knigolyub.ui.fragments.ProfileFragment
import com.mmh.knigolyub.ui.fragments.ProgressFragment
import com.mmh.knigolyub.ui.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            transactionOperation(BooksFragment())
        }

        binding.bubbleBottomBar.addBubbleListener { id ->
            var fragment: Fragment = BooksFragment()
            when (id) {
                R.id.nav_books -> fragment = BooksFragment()
                R.id.nav_progress -> fragment = ProgressFragment()
                R.id.nav_profile -> fragment = ProfileFragment()
                R.id.nav_settings -> fragment = SettingsFragment()
            }
            transactionOperation(fragment)
        }
    }

    private fun transactionOperation(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}