package com.example.domain.interactor

import com.example.domain.Resource
import com.example.domain.models.BookThatReadDomain
import com.example.domain.repository.BookThatReadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetBookThatReadUseCase(private val repository: BookThatReadRepository) {
    fun execute(id: String): Flow<Resource<List<BookThatReadDomain>>> = repository.fetchMyBooks(id = id).flowOn(Dispatchers.IO)
}