package com.mmh.knigolyub.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField

open class Book(
    @PrimaryKey @RealmField("_bookId") var bookId: Int = 0,
    var title: String? = null,
    var author: String? = null,
    var publishYear: Int? = null,
    var numberOfPages: Int? = null,
    var readerId: Int? = null,
    var progress: Int? = null
) : RealmObject()
