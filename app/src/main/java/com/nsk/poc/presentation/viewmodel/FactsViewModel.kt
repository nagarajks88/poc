package com.nsk.poc.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nsk.poc.data.model.FactsResponse
import com.nsk.poc.data.util.Resource
import com.nsk.poc.domain.usecase.facts.GetFactsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactsViewModel @Inject constructor(
    private val useCase: GetFactsUseCase
) : ViewModel() {

    var liveData = MutableLiveData<Resource<FactsResponse>>()

    fun getFacts() {
        liveData.postValue(Resource.Loading())
        viewModelScope.launch {
            val response =useCase.execute()
            liveData.postValue(response)
        }
    }
}