package com.example.data.datasource

import com.example.data.model.Courses

interface NetworkDataSource {
    suspend fun getCourses(): Courses
}