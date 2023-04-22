package com.example.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoursesDto(
    @SerialName("data")
    val data: List<CourseDto>,
)

@Serializable
data class CourseDto(
    val successCriteria: SuccessCriteria,
    val numSoldTickets: Int,
    val status: Status,
    val proposalDueTime: String? = null,
    val title: String,
    val coverImageUrl: String,
    val totalVideoLengthInSeconds: Int? = null
)

@Serializable
data class SuccessCriteria(
    val numSoldTickets: Int
)

@Serializable
enum class Status {
    @SerialName("INCUBATING")
    INCUBATING,

    @SerialName("PUBLISHED")
    PUBLISHED,

    @SerialName("SUCCESS")
    SUCCESS
}