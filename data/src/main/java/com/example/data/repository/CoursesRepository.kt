package com.example.data.repository

import com.example.data.model.CourseDto
import kotlinx.coroutines.flow.Flow

interface CoursesRepository{
    fun getCoursesResources(): Flow<List<CourseDto>>
}