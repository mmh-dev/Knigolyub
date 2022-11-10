package com.mmh.domain.repository

import com.mmh.domain.Resource
import com.mmh.domain.models.ClassDomain
import kotlinx.coroutines.flow.Flow

interface ClassRepository {

    fun fetchAllClass(schoolId: String): Flow<Resource<List<ClassDomain>>>

    fun fetchAllClassCloud(schoolId: String): Flow<Resource<List<ClassDomain>>>


    fun deleteClass(id: String): Flow<Resource<Unit>>

    fun addClass(title: String, schoolId: String): Flow<Resource<String>>

    fun getClass(id: String): Flow<Resource<Unit>>

    suspend fun clearTable()

}