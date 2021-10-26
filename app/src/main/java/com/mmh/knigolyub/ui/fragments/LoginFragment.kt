package com.mmh.knigolyub.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.mmh.knigolyub.R
import com.mmh.knigolyub.app
import com.mmh.knigolyub.databinding.FragmentLoginBinding
import com.mmh.knigolyub.utils.RC_SIGN_IN
import com.mmh.knigolyub.utils.showToast
import com.mmh.knigolyub.utils.transactionOperation
import com.thekhaeng.pushdownanim.PushDownAnim
import io.realm.mongodb.App
import io.realm.mongodb.Credentials


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var userEmail: String
    private lateinit var userPassword: String
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onStart() {
        super.onStart()
        //        val account = GoogleSignIn.getLastSignedInAccount(this)
//        if (account != null) {
//            startActivity(Intent(this@Login, MainActivity::class.java))
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        app.loginAsync(Credentials.anonymous(), App.Callback {
//            if (it.isSuccess){
//                transactionOperation(BooksFragment())
//            }
//            else{
//                showToast("login failure")
//            }
//        })

//        createGoogleSignInRequest()

        binding.apply {
            PushDownAnim.setPushDownAnimTo(signInBtn)
                .setOnClickListener {
                    userEmail = email.text.toString()
                    userPassword = password.text.toString()
                    signInWithEmail(userEmail, userPassword)
                }
            signUpLink.setOnClickListener {
                transactionOperation(SignUpFragment())
            }

            PushDownAnim.setPushDownAnimTo(googleSignInBtn)
                .setOnClickListener {
                    signInWithGoogle()
                }
        }
    }

    private fun createGoogleSignInRequest() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestServerAuthCode(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
    }

    private fun signInWithEmail(userEmail: String, userPassword: String) {
        app.loginAsync(Credentials.emailPassword(userEmail, userPassword), App.Callback {
            if (it.isSuccess) {
                showToast("Welcome!")
                transactionOperation(BooksFragment())

            } else {
                showToast("login failure")
            }
        })
    }

    private fun signInWithGoogle() {

//        val signInIntent: Intent = googleSignInClient.signInIntent
//        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(task: Task<GoogleSignInAccount>?) {
        try {
            val account: GoogleSignInAccount? = task?.result
            val authorizationCode: String? = account?.serverAuthCode
            val googleCredentials: Credentials = Credentials.google(authorizationCode)
            app.loginAsync(googleCredentials) {
                if (it.isSuccess) {
                    showToast("Welcome!")
                    transactionOperation(BooksFragment())
                } else {
                    Log.e("AUTH", "Failed to log in to MongoDB Realm", it.error)
                }
            }
        } catch (e: ApiException) {
            Log.e("AUTH", "Failed to authenticate using Google OAuth: " + e.message);
        }
    }

}