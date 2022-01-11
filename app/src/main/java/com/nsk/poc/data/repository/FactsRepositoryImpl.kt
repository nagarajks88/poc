package com.nsk.poc.data.repository

import com.nsk.poc.data.model.FactsResponse
import com.nsk.poc.data.repository.datasource.FactsRemoteDataSource
import com.nsk.poc.data.util.Resource
import com.nsk.poc.data.util.handleRequest
import com.nsk.poc.domain.repository.FactsRepository

class FactsRepositoryImpl(
    private val remoteDataSource: FactsRemoteDataSource
): FactsRepository {
    override suspend fun getFacts(): Resource<FactsResponse> {
        return handleRequest { remoteDataSource.getFacts() }
    }

}