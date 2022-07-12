package com.rafabarbeytodev.android.kotlin.mvvm.ui.mainviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafabarbeytodev.android.kotlin.mvvm.common.TypeError
import com.rafabarbeytodev.android.kotlin.mvvm.domain.GetQuotesUseCase
import com.rafabarbeytodev.android.kotlin.mvvm.domain.GetRandomQuoteUseCase
import com.rafabarbeytodev.android.kotlin.mvvm.data.model.QuoteModel
import kotlinx.coroutines.launch

/**Segundo paso será crear nuestro ViewModel*/
class QuoteViewModel : ViewModel() { //La clase extiende de ViewModel

    /** Implementamos LiveData, que no es más que un tipo de datos al cual nuestra activity
    se puede conectar para saber cuando hay un cambio en dicho modelo. Por eso fíjate que
    quoteModel es un MutableLiveData<QuoteModel>, es decir, es live data para que la actividad
    se pueda conectar, pero como el valor va a ser modificado es mutable y ese modelo de datos
    encapsula el objeto que queremos acceder, en este caso será un QuoteModel porque iremos
    cambiando la cita cada vez que el usuario toque la pantalla.*/
    val quoteModel = MutableLiveData<QuoteModel>()

    /**Progressbar*/
    val isLoading = MutableLiveData<Boolean>()

    /** Gestion de errores*/
    private val typeError: MutableLiveData<TypeError> = MutableLiveData()


    /**Luego tenemos un método que será al que acceda nuestra vista,
    que primero llama a nuestro provider para que nos devuelva una nueva cita
    (llamaremos a este método cada vez que se pulse la pantalla) y luego se lo
    añadiremos a nuestro live data con postValue().
    Y como nuestro objeto ha sido modificado la actividad lo sabrá al momento y
    pintará los cambios.*/

    var getQuotesUseCase = GetQuotesUseCase()
    fun onCreate() {
        viewModelScope.launch {
            /**mostramos el progressbar*/
            isLoading.postValue(true)

            val result = getQuotesUseCase()
            /**Obtenemos el listado de citas llamando a ese caso de uso*/
            if (result.isNotEmpty()) {
                quoteModel.postValue(result[0])
                /** Mostramos la primera cita por defecto*/
            } else {
                setTypeError(TypeError.GET)
            }

            /**ocultamos el progressbar*/
            isLoading.postValue(false)

        }
    }

    var getRandomQuoteUseCase = GetRandomQuoteUseCase()
    fun randomQuote() {
        /**mostramos el progressbar*/
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null) {
            quoteModel.postValue(quote)
        }
        /**ocultamos el progressbar*/
        isLoading.postValue(false)
    }

    fun getTypeError(): MutableLiveData<TypeError> = typeError

    private fun setTypeError(typeError: TypeError) {
        this.typeError.value = typeError
    }

}