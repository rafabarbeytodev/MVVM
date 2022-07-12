package com.rafabarbeytodev.android.kotlin.mvvm.data.model

/** Este es el erepositorio local de los datos cargados y que inicializamos a vacio, para evitar
 * crash en caso de fallo en la carga
 */
class QuoteProvider {
    companion object {
        var quotes:List<QuoteModel>  = emptyList()
    }
}