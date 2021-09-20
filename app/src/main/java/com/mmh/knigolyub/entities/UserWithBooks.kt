package com.mmh.knigolyub.entities

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithBooks(

    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "readerId"
    )
    val books: List<Book>
)
