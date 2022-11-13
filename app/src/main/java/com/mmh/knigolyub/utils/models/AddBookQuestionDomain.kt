package com.mmh.knigolyub.utils.models

data class AddBookQuestionDomain(
    val question: String,
    val a: String,
    val b: String,
    val d: String,
    val c: String,
    val rightAnswer: String,
    val bookId: String,
    val chapter: String,
)
