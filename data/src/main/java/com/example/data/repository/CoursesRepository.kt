package com.example.data.repository

import com.example.data.model.Courses
import kotlinx.coroutines.flow.Flow

interface CoursesRepository{
    fun getCoursesResources(): Flow<Courses>
}