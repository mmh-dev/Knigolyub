package com.mmh.knigolyub.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey(autoGenerate = true) var bookId: Int = 0,
    var title: String,
    var author: String,
    var publishYear: Int,
    var numberOfPages: Int,
    var readerId: Int,
    var progress: Int
)
