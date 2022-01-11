package com.nsk.poc.presentation.di

import com.nsk.poc.domain.repository.FactsRepository
import com.nsk.poc.domain.usecase.facts.GetFactsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun providesFactsUseCase(repository: FactsRepository): GetFactsUseCase {
        return GetFactsUseCase(repository)
    }

}