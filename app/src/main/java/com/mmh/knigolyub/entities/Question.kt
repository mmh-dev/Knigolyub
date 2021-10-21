package com.mmh.knigolyub.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*

open class Question(
    @PrimaryKey @RealmField("_id") var id: String = UUID.randomUUID().toString(),
    var school: String? = null,
    var bookId: String? = null,
    var chapterId: String? = null,
    var questionText: String? = null,
    var answer1: String? = null,
    var answer2: String? = null,
    var answer3: String? = null,
    var answer4: String? = null,
    var correctAnswer: String? = null
) : RealmObject()
