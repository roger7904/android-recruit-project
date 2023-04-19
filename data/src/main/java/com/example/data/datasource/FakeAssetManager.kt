package com.example.data.datasource

import java.io.InputStream

fun interface FakeAssetManager {
    fun open(fileName: String): InputStream
}