package com.nsk.poc.domain.usecase.facts

import com.nsk.poc.data.model.FactsResponse
import com.nsk.poc.data.util.Resource
import com.nsk.poc.domain.repository.FactsRepository

class GetFactsUseCase(
    private val factsRepository: FactsRepository
) {

    suspend fun execute(): Resource<FactsResponse> {
        return factsRepository.getFacts()
    }
}