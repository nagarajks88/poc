package com.nsk.poc.presentation.di

import com.nsk.poc.data.repository.FactsRepositoryImpl
import com.nsk.poc.data.repository.datasource.FactsRemoteDataSource
import com.nsk.poc.data.repository.datasourceimpl.FactsRemoteDataSourceImpl
import com.nsk.poc.domain.repository.FactsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesFactsRepository(factsRemoteDataSource: FactsRemoteDataSource): FactsRepository {
        return FactsRepositoryImpl(factsRemoteDataSource)
    }

}