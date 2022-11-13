package com.mmh.domain.repository

import com.mmh.domain.Resource
import com.mmh.domain.models.SchoolDomain
import kotlinx.coroutines.flow.Flow

interface SchoolRepository {

    fun getAllSchools(): Flow<Resource<List<SchoolDomain>>>
}