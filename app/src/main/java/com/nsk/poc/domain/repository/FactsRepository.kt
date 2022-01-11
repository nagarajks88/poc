package com.nsk.poc.domain.repository

import com.nsk.poc.data.model.FactsResponse
import com.nsk.poc.data.util.Resource

interface FactsRepository {

    suspend fun getFacts() : Resource<FactsResponse>
}