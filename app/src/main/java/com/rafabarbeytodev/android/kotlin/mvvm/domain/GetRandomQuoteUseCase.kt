package com.rafabarbeytodev.android.kotlin.mvvm.domain

import com.rafabarbeytodev.android.kotlin.mvvm.data.model.QuoteModel
import com.rafabarbeytodev.android.kotlin.mvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(quotes.isNotEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}