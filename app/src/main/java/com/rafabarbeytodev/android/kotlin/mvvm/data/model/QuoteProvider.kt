package com.rafabarbeytodev.android.kotlin.mvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

/** Este es el erepositorio local de los datos cargados y que inicializamos a vacio, para evitar
 * crash en caso de fallo en la carga
 */

@Singleton //Para que solo exista una unica instancia con las citas
class QuoteProvider @Inject constructor(){
    //Lo eliminamos al inyectarlo
    //companion object {
        var quotes:List<QuoteModel>  = emptyList()
    //}
}