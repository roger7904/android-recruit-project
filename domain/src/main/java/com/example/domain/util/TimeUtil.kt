package com.example.domain.util

import java.time.Duration
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun String.calculateDaysRemain(): Long? {
    // 將字串轉換為 ZonedDateTime
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    val dateTime = ZonedDateTime.parse(this, formatter)

    // 獲取當前的 ZonedDateTime
    val now = ZonedDateTime.now()

    // 計算兩個日期之間的 Duration
    val duration = Duration.between(now, dateTime)

    if (duration.toDays() <= 0) {
        return null
    }

    // 將 Duration 轉換為天數
    return duration.toDays()
}