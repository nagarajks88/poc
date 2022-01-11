package com.nsk.poc.data.repository.datasourceimpl

import com.nsk.poc.data.api.RestService
import com.nsk.poc.data.model.FactsResponse
import com.nsk.poc.data.repository.datasource.FactsRemoteDataSource
import retrofit2.Response

class FactsRemoteDataSourceImpl(
    private val service: RestService
) : FactsRemoteDataSource {


    override suspend fun getFacts(): Response<FactsResponse> {
        return service.getFacts()
    }


}