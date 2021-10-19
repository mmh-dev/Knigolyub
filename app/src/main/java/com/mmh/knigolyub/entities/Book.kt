package com.mmh.knigolyub.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*

open class Book() : RealmObject() {

    @PrimaryKey
    @RealmField("_id")
    var bookId: String = UUID.randomUUID().toString()
    var title: String? = null
    var author: String? = null
    var publishYear: String? = null
    var numberOfPages: String? = null
    var progress: String? = null
    var readerId: String? = null


}




