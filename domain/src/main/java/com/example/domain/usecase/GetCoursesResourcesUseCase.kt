package com.example.domain.usecase

import com.example.data.model.Status
import com.example.data.repository.CoursesRepository
import com.example.domain.model.Course
import com.example.domain.util.time.calculateDaysRemain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCoursesResourcesUseCase @Inject constructor(
    private val coursesRepository: CoursesRepository
) {
    operator fun invoke(): Flow<List<Course>> =
        coursesRepository.getCoursesResources().map { coursesDto ->
            coursesDto.map { courseDto ->
                when (courseDto.status) {
                    Status.INCUBATING -> {
                        val daysRemain: Long? = courseDto.proposalDueTime?.calculateDaysRemain()
                        Course.Incubating(
                            title = courseDto.title,
                            successCriteria = courseDto.successCriteria,
                            numSoldTickets = courseDto.numSoldTickets,
                            coverImageUrl = courseDto.coverImageUrl,
                            isExpired = daysRemain == null,
                            countDown = daysRemain
                        )
                    }
                    Status.PUBLISHED -> Course.Published(
                        title = courseDto.title,
                        successCriteria = courseDto.successCriteria,
                        numSoldTickets = courseDto.numSoldTickets,
                        coverImageUrl = courseDto.coverImageUrl
                    )
                    Status.SUCCESS -> Course.Success(
                        title = courseDto.title,
                        successCriteria = courseDto.successCriteria,
                        numSoldTickets = courseDto.numSoldTickets,
                        coverImageUrl = courseDto.coverImageUrl
                    )
                }
            }
        }
}