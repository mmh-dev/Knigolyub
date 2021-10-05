package com.mmh.knigolyub.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField

open class User(
    @PrimaryKey @RealmField("_userId") var userId: Int = 0,
    var name: String? = null,
    var password: String? = null,
    var email: String? = null,
    var school: String? = null,
    var grade: Int? = null,
    var gradeLetter: String? = null,
    var isMale: Boolean? = null,
    var phone: Int? = null,
    var status: String? = null
) : RealmObject()
