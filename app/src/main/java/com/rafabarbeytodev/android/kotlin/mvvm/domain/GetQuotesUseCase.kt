package com.rafabarbeytodev.android.kotlin.mvvm.domain

import com.rafabarbeytodev.android.kotlin.mvvm.data.model.QuoteModel
import com.rafabarbeytodev.android.kotlin.mvvm.data.QuoteRepository

/** Caso de uso para cargar todas las citas **/
class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel> = repository.getAllQuotes()

}