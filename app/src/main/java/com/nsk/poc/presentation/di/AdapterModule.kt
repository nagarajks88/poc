package com.nsk.poc.presentation.di

import com.nsk.poc.presentation.adapter.FactsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    fun providesFactsAdapter() : FactsAdapter {
        return FactsAdapter()
    }
}