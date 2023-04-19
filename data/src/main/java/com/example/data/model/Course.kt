package com.example.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Courses(
    @SerialName("data")
    val data: List<Course>? = null,
)

@Serializable
data class Course(
    val successCriteria: SuccessCriteria? = null,
    val numSoldTickets: Int? = null,
    val status: Status? = null,
    val proposalDueTime: String? = null,
    val title: String? = null,
    val coverImageUrl: String? = null,
    val totalVideoLengthInSeconds: Int? = null
)

@Serializable
data class SuccessCriteria(
    val numSoldTickets: Int? = null
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