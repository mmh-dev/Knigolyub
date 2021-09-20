package com.mmh.knigolyub.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) var userId: Int,
    var name: String,
    var password: String,
    var email: String,
    var school: String,
    var grade: Int,
    var gradeLetter: String,
    var isMale: Boolean,
    var phone: Int,
    var status: String
)
