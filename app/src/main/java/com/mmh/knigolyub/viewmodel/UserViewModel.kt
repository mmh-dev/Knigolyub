package com.mmh.knigolyub.viewmodel

import androidx.lifecycle.ViewModel
import com.mmh.knigolyub.entities.Grade
import com.mmh.knigolyub.entities.User
import com.mmh.knigolyub.ui.activities.MainActivity
import io.realm.kotlin.where

class UserViewModel : ViewModel() {

    val students = mutableListOf<User>()


    fun getAllStudents(): List<User> {
        val results = MainActivity.userRealm?.where<User>()
            ?.findAll()
        MainActivity.userRealm?.copyFromRealm(results)?.let { students.addAll(it) }
        return students
    }

    fun getStudentsOfGrade(school: String, grade: String, gradeLetter: String): List<User> {
        val results = MainActivity.userRealm?.where<User>()
            ?.contains("school", school)
            ?.contains("grade", grade)
            ?.contains("gradeLetter", gradeLetter)
            ?.findAll()
        MainActivity.userRealm?.copyFromRealm(results)?.let { students.addAll(it) }
        return students
    }

    fun getGrades(school: String): List<Grade> {
        val grades = mutableListOf<Grade>()
        val results = MainActivity.userRealm?.where<Grade>()
            ?.contains("school", school)
            ?.findAll()
        MainActivity.userRealm?.copyFromRealm(results)?.let { grades.addAll(it) }
        return grades
    }

    fun addNewReader(user: User) {
        MainActivity.userRealm?.executeTransactionAsync {
            it.insert(user)
        }
        getAllStudents()
    }

    fun addNewGrade(grade: Grade) {
        MainActivity.userRealm?.executeTransactionAsync {
            it.insert(grade)
        }
    }

    fun updateReader(param: String, oldValue: String, newValue: String) {
        MainActivity.userRealm?.executeTransactionAsync {
            val user: User = it
                .where<User>()
                .equalTo(param, oldValue)
                .findFirst()!!
            it.insertOrUpdate(changeUserParam(user, param, newValue))
        }
        getAllStudents()
    }

    fun deleteReader(param: String, value: String) {
        MainActivity.userRealm?.executeTransactionAsync {
            val user = it
                .where<User>()
                .equalTo(param, value)
                .findFirst()
            user?.deleteFromRealm()
        }
        getAllStudents()
    }

    fun deleteGrade(school: String, grade: String, gradeLetter: String) {
        MainActivity.userRealm?.executeTransactionAsync {
            val user = it
                .where<User>()
                .equalTo("school", school)
                .equalTo("grade", grade)
                .equalTo("gradeLetter", gradeLetter)
                .findFirst()
            user?.deleteFromRealm()
        }
    }

    private fun changeUserParam(user: User, param: String, newValue: String): User {
        when (param) {
            "lastName" -> {
                user.lastName = newValue
            }
            "firstName" -> {
                user.firstName = newValue
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