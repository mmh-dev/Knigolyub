package com.mmh.knigolyub.viewmodel

import androidx.lifecycle.ViewModel
import com.mmh.knigolyub.entities.User
import com.mmh.knigolyub.ui.activities.MainActivity
import io.realm.kotlin.where

class UserViewModel : ViewModel() {

    fun getAllStudents(): List<User> {
        val students = mutableListOf<User>()
        val results = MainActivity.userRealm?.where<User>()
            ?.findAll()
        MainActivity.userRealm?.copyFromRealm(results)?.let { students.addAll(it) }
        return students
    }

    fun getStudentsOfClass(grade: String, gradeLetter: String): List<User> {
        val students = mutableListOf<User>()
        val results = MainActivity.userRealm?.where<User>()
            ?.contains("grade", grade)
            ?.contains("gradeLetter", gradeLetter)
            ?.findAll()
        MainActivity.userRealm?.copyFromRealm(results)?.let { students.addAll(it) }
        return students
    }

    fun addNewUser(user: User) {
        MainActivity.userRealm?.executeTransactionAsync {
            it.insert(user)
        }
    }

    fun updateUser(param: String, oldValue: String, newValue: String) {
        MainActivity.userRealm?.executeTransactionAsync {
            val user: User = it
                .where<User>()
                .equalTo(param, oldValue)
                .findFirst()!!
            it.insertOrUpdate(changeUserParam(user, param, newValue))
        }
    }

    fun deleteUser(param: String, value: String) {
        MainActivity.userRealm?.executeTransactionAsync {
            val user = it
                .where<User>()
                .equalTo(param, value)
                .findFirst()
            user?.deleteFromRealm()
        }
    }

    private fun changeUserParam(user: User, param: String, newValue: String): User {
        when (param) {
            "name" -> {
                user.name = newValue
            }
            "password" -> {
                user.password = newValue
            }
            "email" -> {
                user.email = newValue
            }
            "school" -> {
                user.school = newValue
            }
            "grade" -> {
                user.grade = newValue
            }
            "gradeLetter" -> {
                user.gradeLetter = newValue
            }
            "gender" -> {
                user.gender = newValue
            }
            "phone" -> {
                user.phone = newValue
            }
            "status" -> {
                user.status = newValue
            }
        }
        return user
    }
}