package com.example.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Course(
    val successCriteria: SuccessCriteria?,
    val numSoldTickets: Int?,
    val status: Status?,
    val proposalDueTime: String?,
    val title: String?,
    val coverImageUrl: String?,
    val totalVideoLengthInSeconds: Int?
)

@Serializable
data class SuccessCriteria(
    val numSoldTickets: Int?
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