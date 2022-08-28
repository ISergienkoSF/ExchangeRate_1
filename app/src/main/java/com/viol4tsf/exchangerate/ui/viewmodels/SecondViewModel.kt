package com.viol4tsf.exchangerate.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viol4tsf.exchangerate.data.repository.Repository
import com.viol4tsf.exchangerate.model.cash.Cash
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Cash> = MutableLiveData()

    fun getCash() {
        viewModelScope.launch {
            val response: Cash = repository.getCashR()
            myResponse.value = response
        }
    }
}