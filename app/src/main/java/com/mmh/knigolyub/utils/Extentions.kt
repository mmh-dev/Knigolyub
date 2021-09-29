package com.mmh.knigolyub.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mmh.knigolyub.R

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Fragment.transactionOperation(fragment: Fragment) {
    val transaction = fragmentManager?.beginTransaction()
    transaction?.replace(R.id.fragmentContainer, fragment)
    transaction?.commit()
}

//fun Context.transactionOperation(fragment: Fragment) {
//    if (this is Activity){
//        val transaction = this.fragmentManager.beginTransaction()
//        transaction.replace(R.id.fragmentContainer, fragment )
//        transaction.commit()
//    }

