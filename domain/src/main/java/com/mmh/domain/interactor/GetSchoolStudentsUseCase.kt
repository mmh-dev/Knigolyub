package com.mmh.domain.interactor

import com.example.domain.repository.UserRepository

class GetSchoolStudentsUseCase(private val repository: UserRepository) {
    fun execute(schoolId: String) = repository.fetchSchoolStudents(schoolId = schoolId)
}