package com.example.domain.model

import com.example.data.model.SuccessCriteria

sealed class Course {
    data class Incubating(
        val title: String,
        val successCriteria: SuccessCriteria,
        val numSoldTickets: Int,
        val coverImageUrl: String,
        val isExpired: Boolean,
        val countDown: Long?,
    ) : Course()

    data class Published(
        val title: String,
        val successCriteria: SuccessCriteria,
        val numSoldTickets: Int,
        val coverImageUrl: String,
    ) : Course()

    data class Success(
        val title: String,
        val successCriteria: SuccessCriteria,
        val numSoldTickets: Int,
        val coverImageUrl: String,
    ) : Course()
}