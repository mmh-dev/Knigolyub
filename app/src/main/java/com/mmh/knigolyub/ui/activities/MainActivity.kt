package com.mmh.knigolyub.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mmh.knigolyub.R
import com.mmh.knigolyub.app
import com.mmh.knigolyub.databinding.ActivityMainBinding
import com.mmh.knigolyub.ui.fragments.BooksFragment
import com.mmh.knigolyub.ui.fragments.ProfileFragment
import com.mmh.knigolyub.ui.fragments.ProgressFragment
import com.mmh.knigolyub.ui.fragments.SettingsFragment
import com.mmh.knigolyub.utils.PARTITION_VALUE
import com.mmh.knigolyub.utils.transactionOperation
import io.realm.Realm
import io.realm.mongodb.sync.SyncConfiguration

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        var user: io.realm.mongodb.User? = null
        var userRealm: Realm? = null
    }

    override fun onStart() {
        super.onStart()
        user = app.currentUser()
        if (user == null) {
            startActivity(Intent(this, Login::class.java))
        } else {
            val config = SyncConfiguration.Builder(user!!, PARTITION_VALUE)
                .build()

            userRealm = Realm.getInstance(config)
        }
    }

    override fun onStop() {
        super.onStop()
        user.run {
            userRealm?.close()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        userRealm?.close()
    }

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
}