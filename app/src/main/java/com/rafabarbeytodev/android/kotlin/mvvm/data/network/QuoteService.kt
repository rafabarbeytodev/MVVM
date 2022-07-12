package com.rafabarbeytodev.android.kotlin.mvvm.data.network

import com.rafabarbeytodev.android.kotlin.mvvm.common.RetrofitHelper
import com.rafabarbeytodev.android.kotlin.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(APIService::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}