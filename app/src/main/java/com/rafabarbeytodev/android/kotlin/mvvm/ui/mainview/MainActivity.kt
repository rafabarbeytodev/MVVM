package com.rafabarbeytodev.android.kotlin.mvvm.ui.mainview

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import com.rafabarbeytodev.android.kotlin.mvvm.common.TypeError
import com.rafabarbeytodev.android.kotlin.mvvm.databinding.ActivityMainBinding
import com.rafabarbeytodev.android.kotlin.mvvm.ui.mainviewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    /**La idea es unir la actividad a nuestro ViewModel para poder estar suscrito a
     * los cambios y modificar la UI cuando sea necesario.
     *
     * Gracias a la librería de activity que añadimos al gradle,
     * asignar un ViewModel es mas sencillo. Solo tenemos que crear un atributo
     * de clase definiendo nuestro ViewModel y llamar a by viewModels().*/
    private val quoteViewModel: QuoteViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        /** Primer caso de uso (Interactor) que es cargar todas la citas de internet y guardarlas en un
         * repositorio local (QuoteProvider)*/
        quoteViewModel.onCreate()

        /** Añadimos un setOnClickListener al constraintLayout principal.
         * Este será el segundo caso de uso (Interactor) que consiste en mostrar una cita aleatoria en cada click*/

        mBinding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

        /** Nos queda suscribirnos a los cambios.
         *live data es básicamente el patrón observe por lo que definirlo es muy sencillo.*/

        /**Cambios en las citas */
        quoteViewModel.getQuoteModel().observe(this) { currentQuote ->
            if (currentQuote?.quote?.isNotEmpty() == true) {
                mBinding.tvQuote.text = currentQuote.quote
                mBinding.tvAuthor.text = currentQuote.author
            }
        }
        /**Cambios en el ProgressBar*/
        quoteViewModel.getIsLoading().observe(this) { visibility ->
            mBinding.loading.isVisible = visibility
        }

        /**Cambios en la gestión de errores*/
        quoteViewModel.getTypeError().observe(this) { typeError ->
            val msgRes = when (typeError) {
                TypeError.GET -> "Error al cargar datos del repositorio externo"
                else -> "Error desconocido"
            }
            Snackbar.make(mBinding.root, msgRes, Snackbar.LENGTH_SHORT).show()
        }


    }
}