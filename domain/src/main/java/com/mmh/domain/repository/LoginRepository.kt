package com.mmh.domain.repository

import com.mmh.domain.Resource
import com.mmh.domain.models.PostRequestAnswerDomain
import com.mmh.domain.models.UserDomain
import com.mmh.domain.models.UserSignUpDomain
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun signIn(email: String, password: String): Flow<Resource<UserDomain>>

    fun signUp(user: UserSignUpDomain): Flow<Resource<PostRequestAnswerDomain>>

    fun passwordReset(email: String): Flow<Resource<Unit>>
}