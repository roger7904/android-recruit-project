package com.example.data.datasource

import com.example.data.model.CoursesDto

interface NetworkDataSource {
    suspend fun getCourses(): CoursesDto
}