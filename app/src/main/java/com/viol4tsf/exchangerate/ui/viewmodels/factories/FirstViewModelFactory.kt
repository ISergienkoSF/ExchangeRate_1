package com.viol4tsf.exchangerate.ui.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.viol4tsf.exchangerate.data.repository.Repository
import com.viol4tsf.exchangerate.ui.viewmodels.FirstViewModel

class FirstViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FirstViewModel(repository) as T
    }

}