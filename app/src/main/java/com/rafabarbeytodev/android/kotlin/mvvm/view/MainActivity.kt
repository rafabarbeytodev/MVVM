package com.rafabarbeytodev.android.kotlin.mvvm.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rafabarbeytodev.android.kotlin.mvvm.databinding.ActivityMainBinding
import com.rafabarbeytodev.android.kotlin.mvvm.viewmodel.QuoteViewModel

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

        /** Nos queda suscribirnos a los cambios.
         *live data es básicamente el patrón observe por lo que definirlo es muy sencillo.*/

        quoteViewModel.quoteModel.observe(this) { currentQuote ->
            mBinding.tvQuote.text = currentQuote.quote
            mBinding.tvAuthor.text = currentQuote.author
        }

        /** Vamos a terminar añadiendo un setOnClickListener al constraintLayout principal.*/
        mBinding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}