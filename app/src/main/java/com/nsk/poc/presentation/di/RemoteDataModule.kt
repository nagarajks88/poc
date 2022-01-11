package com.nsk.poc.presentation.di

import com.nsk.poc.data.api.RestService
import com.nsk.poc.data.repository.datasource.FactsRemoteDataSource
import com.nsk.poc.data.repository.datasourceimpl.FactsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    fun providesFactsRemoteDataSource(service: RestService): FactsRemoteDataSource {
        return FactsRemoteDataSourceImpl(service)
    }
}