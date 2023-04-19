package com.example.data.di

import com.example.data.repository.CoursesRepository
import com.example.data.repository.FakeCoursesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindsCourseResourceRepository(
        courseRepository: FakeCoursesRepository,
    ): CoursesRepository
}