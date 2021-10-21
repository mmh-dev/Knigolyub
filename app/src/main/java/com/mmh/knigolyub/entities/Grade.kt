package com.mmh.knigolyub.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*

open class Grade(
    @PrimaryKey @RealmField("_id") var id: String = UUID.randomUUID().toString(),
    var school: String? = null,
    var grade: String? = null,
    var gradeLetter: String? = null
) : RealmObject()