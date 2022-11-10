package com.mmh.knigolyub.utils.models

import java.util.*

data class PostRequestAnswerDomain(
    val id: String,
    val createdAt: Date,
    val image: UserDomainImage,
    val sessionToken: String,
)