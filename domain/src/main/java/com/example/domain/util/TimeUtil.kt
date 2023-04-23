package com.example.domain.util

import java.time.Duration
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun String.calculateDaysRemain(): Long? {
    // convert string to ZonedDateTime
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    val dateTime = ZonedDateTime.parse(this, formatter)

    // get current ZonedDateTime
    val now = ZonedDateTime.now()

    // calculate Duration between now and dateTime
    val duration = Duration.between(now, dateTime)

    if (duration.toDays() <= 0) {
        return null
    }

    // convert Duration to days
    return duration.toDays()
}