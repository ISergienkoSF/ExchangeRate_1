package com.viol4tsf.exchangerate.screens.second

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.viol4tsf.exchangerate.data.repository.Repository
import com.viol4tsf.exchangerate.screens.first.FirstViewModel

class SecondViewModelFactory (private val repository: Repository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SecondViewModel(repository) as T
    }
}