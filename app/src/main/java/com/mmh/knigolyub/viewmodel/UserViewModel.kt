package com.mmh.knigolyub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mmh.knigolyub.entities.User
import com.mmh.knigolyub.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            UserRepository.getAllUsers()
        }
    }

    fun getUser(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            UserRepository.getUser(userId)
        }
    }

    fun insertUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            UserRepository.insertUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            UserRepository.updateUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            UserRepository.deleteUser(user)
        }
    }

    fun clearUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            UserRepository.clearUsers()
        }
    }

    fun getUserWithBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            UserRepository.getUsersWithBooks()
        }
    }

}