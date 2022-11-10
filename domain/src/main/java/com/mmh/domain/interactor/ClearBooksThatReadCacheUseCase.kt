package com.mmh.domain.interactor

import com.example.domain.repository.BookThatReadRepository

class ClearBooksThatReadCacheUseCase(private val repository: BookThatReadRepository) {

    suspend fun execute() = repository.clearBooksCache()

}