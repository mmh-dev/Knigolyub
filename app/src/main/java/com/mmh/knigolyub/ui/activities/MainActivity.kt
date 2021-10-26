package com.mmh.knigolyub.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mmh.knigolyub.app
import com.mmh.knigolyub.databinding.ActivityMainBinding
import com.mmh.knigolyub.ui.fragments.LoginFragment
import com.mmh.knigolyub.ui.fragments.MainFragment
import com.mmh.knigolyub.utils.PARTITION_VALUE
import com.mmh.knigolyub.utils.transactionOperation
import com.mmh.knigolyub.viewmodel.BookViewModel
import com.mmh.knigolyub.viewmodel.UserViewModel
import io.realm.Realm
import io.realm.mongodb.sync.SyncConfiguration

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val bookViewModel: BookViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()

    companion object {
        var user: io.realm.mongodb.User? = null
        var userRealm: Realm? = null
    }

    override fun onStart() {
        super.onStart()
        user = app.currentUser()
        if (user == null) {
            transactionOperation(LoginFragment())
        } else {
            val config = SyncConfiguration.Builder(user!!, PARTITION_VALUE)
                .build()
            userRealm = Realm.getInstance(config)
        }
        bookViewModel.getAllBooks()
        userViewModel.getAllStudents()
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

        bookViewModel.getAllBooks()
        if (savedInstanceState == null) {
            transactionOperation(MainFragment())
        }
    }
}