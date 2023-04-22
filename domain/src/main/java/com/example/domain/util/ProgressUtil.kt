package com.example.domain.util

fun Int.calculateProgress(total: Int): Int {
    if (total == 0 || this > total) return 100
    return this * 100 / total
}