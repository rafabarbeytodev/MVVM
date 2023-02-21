package com.rafabarbeytodev.android.kotlin.mvvm.domain

import com.rafabarbeytodev.android.kotlin.mvvm.data.model.QuoteModel
import com.rafabarbeytodev.android.kotlin.mvvm.data.QuoteRepository
import javax.inject.Inject

/** Caso de uso para cargar todas las citas
 *  Preparamos para Dagger con @Inject constructor()
 * **/
class GetQuotesUseCase @Inject constructor(
    private val repository:QuoteRepository
) {
    // Lo eliminamos al inyectarlo
    //private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel> = repository.getAllQuotes()

}