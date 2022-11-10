package com.mmh.knigolyub.utils.models

data class AddNewBookThatReadDomain(
    val bookId: String,
    val userId: String,
    val page: Int,
    val publicYear: String,
    val book: String,
    val title: String,
    val chapterCount: Int,
    val poster: BookThatReadPosterDomain,
    val isReadingPages: List<Boolean>,
    val chaptersRead: Int,
    val progress: Int,
    val author: String,
)