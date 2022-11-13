package com.example.domain.interactor

import com.example.domain.Resource
import com.example.domain.models.AddNewBookThatReadDomain
import com.example.domain.repository.BookThatReadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class AddNewBookThatReadUseCase(private val repository: BookThatReadRepository) {
    fun execute(book: AddNewBookThatReadDomain): Flow<Resource<Unit>> = repository.addBook(book = book).flowOn(Dispatchers.IO)
}