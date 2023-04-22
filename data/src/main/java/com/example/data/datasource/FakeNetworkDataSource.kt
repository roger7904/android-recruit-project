package com.example.data.datasource

import com.example.data.model.CoursesDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

class FakeNetworkDataSource @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json,
    private val assets: FakeAssetManager,
) : NetworkDataSource {

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getCourses(): CoursesDto =
        withContext(ioDispatcher) {
            assets.open(COURSES_ASSET).use(networkJson::decodeFromStream)
        }

    companion object {
        private const val COURSES_ASSET = "data.json"
    }
}