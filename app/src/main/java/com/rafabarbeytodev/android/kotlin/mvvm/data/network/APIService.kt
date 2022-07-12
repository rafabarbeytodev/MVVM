package com.rafabarbeytodev.android.kotlin.mvvm.data.network

import com.rafabarbeytodev.android.kotlin.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}