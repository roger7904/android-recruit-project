package com.example.data.repository

import com.example.data.datasource.FakeNetworkDataSource
import com.example.data.model.CourseDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FakeCoursesRepository @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val datasource: FakeNetworkDataSource,
) : CoursesRepository {

    override fun getCoursesResources(): Flow<List<CourseDto>> =
        flow {
            emit(datasource.getCourses().data)
        }.flowOn(ioDispatcher)
}