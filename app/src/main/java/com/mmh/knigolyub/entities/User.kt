package com.mmh.knigolyub.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*

open class User(
    @PrimaryKey @RealmField("_id") var id: String = UUID.randomUUID().toString(),
    var lastName: String? = null,
    var firstName: String? = null,
    var password: String? = null,
    var email: String? = null,
    var school: String? = null,
    var grade: String? = null,
    var gradeLetter: String? = null,
    var gender: String? = null,
    var phone: String? = null,
    var status: String? = null,
    var joinedAt: Date? = null,
) : RealmObject()
