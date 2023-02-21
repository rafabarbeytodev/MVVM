package com.rafabarbeytodev.android.kotlin.mvvm.data

import com.rafabarbeytodev.android.kotlin.mvvm.data.network.QuoteService
import com.rafabarbeytodev.android.kotlin.mvvm.data.model.QuoteModel
import com.rafabarbeytodev.android.kotlin.mvvm.data.model.QuoteProvider
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
) {

    // Lo eliminamos al inyectarlo
    //private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}