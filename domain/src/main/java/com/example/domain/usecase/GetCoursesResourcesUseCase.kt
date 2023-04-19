package com.example.domain.usecase

import com.example.data.model.Courses
import com.example.data.repository.CoursesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoursesResourcesUseCase @Inject constructor(
    private val coursesRepository: CoursesRepository
) {

    operator fun invoke(): Flow<Courses> =
        coursesRepository.getCoursesResources()
}