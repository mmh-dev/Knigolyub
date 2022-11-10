package com.mmh.data

import com.mmh.data.cloud.models.SchoolCloud
import com.mmh.data.cloud.models.UserSignUpCloud
import com.mmh.data.models.BookData
import com.mmh.data.models.BookPdfData
import com.mmh.data.models.BookPosterData
import com.mmh.domain.models.AddNewBookDomain
import com.mmh.domain.models.SchoolDomain
import com.mmh.domain.models.UserSignUpDomain
import java.util.*


internal fun UserSignUpDomain.toDtoSignUp(): UserSignUpCloud = UserSignUpCloud(name = name,
    lastname = lastname,
    email = email,
    password = password,
    number = number,
    className = className,
    schoolName = schoolName,
    gender = gender,
    classId = classId,
    userType = userType,
    username = email,
    schoolId = schoolId,
    userSessionToken = "null")

internal fun AddNewBookDomain.toBook(id: String, createdAt: Date): BookData = BookData(id = id,
    createdAt = createdAt,
    book = BookPdfData(name = book.name, url = book.url, type = book.type),
    author = author,
    poster = BookPosterData(name = poster.name, url = poster.url),
    updatedAt = createdAt,
    chapterCount = chapterCount,
    page = page,
    publicYear = publicYear,
    title = title,
    genres = genres)

internal fun SchoolCloud.toSchool(): SchoolDomain = SchoolDomain(objectId = objectId, title = title)
