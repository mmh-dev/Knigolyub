package com.example.data.mappers

import com.example.data.models.AddBookQuestionData
import com.example.domain.Mapper
import com.example.domain.models.AddBookQuestionDomain

class AddBookQuestionDomainToDataMapper : Mapper<AddBookQuestionDomain, AddBookQuestionData> {
    override fun map(from: AddBookQuestionDomain): AddBookQuestionData = from.run {
        AddBookQuestionData(a = a, b = b, chapter = chapter, c = c, d = d, question = question, rightAnswer = rightAnswer, bookId = bookId)
    }
}