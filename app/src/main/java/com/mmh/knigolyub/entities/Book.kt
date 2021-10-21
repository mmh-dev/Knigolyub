package com.mmh.knigolyub.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*

open class Book(
    @PrimaryKey @RealmField("_id") var id: String = UUID.randomUUID().toString(),
    var school: String? = null,
    var title: String? = null,
    var author: String? = null,
    var publishYear: String? = null,
    var numberOfPages: String? = null,
    var progress: String? = null,
    var readerId: String? = null,
) : RealmObject()




