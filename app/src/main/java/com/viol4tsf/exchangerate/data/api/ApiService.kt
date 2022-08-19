package com.viol4tsf.exchangerate.data.api

import com.viol4tsf.exchangerate.model.cash.Cash
import retrofit2.http.GET

interface ApiService {
    @GET("daily_json.js")
    suspend fun getCash(): Cash
}