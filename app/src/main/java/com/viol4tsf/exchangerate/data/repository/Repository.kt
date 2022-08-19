package com.viol4tsf.exchangerate.data.repository

import com.viol4tsf.exchangerate.data.api.RetrofitInstance
import com.viol4tsf.exchangerate.model.cash.Cash

class Repository {
    suspend fun getCashR(): Cash {
        return RetrofitInstance.api.getCash()
    }
}