package com.nsk.poc.data.repository.datasource

import com.nsk.poc.data.model.FactsResponse
import retrofit2.Response

interface FactsRemoteDataSource {

    suspend fun getFacts() : Response<FactsResponse>
}