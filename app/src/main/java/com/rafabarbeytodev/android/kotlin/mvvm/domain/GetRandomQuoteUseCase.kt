package com.rafabarbeytodev.android.kotlin.mvvm.domain

import com.rafabarbeytodev.android.kotlin.mvvm.data.model.QuoteModel
import com.rafabarbeytodev.android.kotlin.mvvm.data.model.QuoteProvider
import javax.inject.Inject

/**
 * Preparamos para Dagger con @Inject constructor()
 **/
class GetRandomQuoteUseCase @Inject constructor(
    private val quoteProvider: QuoteProvider
) {
    operator fun invoke(): QuoteModel?{
        val quotes = quoteProvider.quotes
        if(quotes.isNotEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}