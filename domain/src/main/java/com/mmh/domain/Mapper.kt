package com.mmh.domain

interface Mapper<From, To> {

    fun map(from: From): To
}