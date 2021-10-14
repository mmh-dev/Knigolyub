package com.mmh.knigolyub.viewmodel

import androidx.lifecycle.ViewModel
import com.mmh.knigolyub.entities.User
import com.mmh.knigolyub.realmSync.LiveRealmResults

class UserViewModel : ViewModel() {

    var userList: LiveRealmResults<User>? = null

    fun getUsers() {

    }

    fun addNewUser() {

    }
}