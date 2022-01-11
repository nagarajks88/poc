package com.nsk.poc.presentation.di

import com.nsk.poc.data.api.RestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetModule {


    @Provides
    fun salesEdgeService(retrofit: Retrofit): RestService {
        return retrofit.create(RestService::class.java)
    }

    @Provides
    fun providesGsonConvertorFactory() : GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun providesConverterScalarsFactory(): ScalarsConverterFactory {
        return ScalarsConverterFactory.create()
    }

    @Provides
    fun providesBaseUrl() : String {
        return "https://dl.dropboxusercontent.com/s/";
    }

    @Provides
    fun provideRetrofitInstance(gsonConverterFactory: GsonConverterFactory,
                                baseUrl : String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(baseUrl)
            .build()
    }

}