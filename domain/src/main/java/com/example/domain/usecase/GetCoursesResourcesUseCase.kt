package com.example.domain.usecase

import com.example.data.model.Status
import com.example.data.repository.CoursesRepository
import com.example.domain.model.Course
import com.example.domain.util.calculateDaysRemain
import com.example.domain.util.calculateProgress
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
                            countDown = daysRemain,
                            progressText = "${courseDto.numSoldTickets} / ${
                                courseDto.successCriteria.numSoldTickets
                            } 人",
                            progress = courseDto.numSoldTickets.calculateProgress(
                                courseDto.successCriteria.numSoldTickets
                            )
                        )
                    }
                    Status.PUBLISHED -> Course.Published(
                        title = courseDto.title,
                        successCriteria = courseDto.successCriteria,
                        numSoldTickets = courseDto.numSoldTickets,
                        coverImageUrl = courseDto.coverImageUrl,
                        progressText = "${
                            courseDto.numSoldTickets.calculateProgress(
                                courseDto.successCriteria.numSoldTickets
                            )
                        }%",
                        progress = courseDto.numSoldTickets.calculateProgress(
                            courseDto.successCriteria.numSoldTickets
                        )
                    )
                    Status.SUCCESS -> Course.Success(
                        title = courseDto.title,
                        successCriteria = courseDto.successCriteria,
                        numSoldTickets = courseDto.numSoldTickets,
                        coverImageUrl = courseDto.coverImageUrl,
                        progressText = "${courseDto.numSoldTickets} / ${
                            courseDto.successCriteria.numSoldTickets
                        } 人",
                        progress = courseDto.numSoldTickets.calculateProgress(
                            courseDto.successCriteria.numSoldTickets
                        )
                    )
                }
            }.filter { course -> // Filter out expired incubating courses
                when (course) {
                    is Course.Incubating -> !course.isExpired
                    else -> true
                }
            }
        }
}