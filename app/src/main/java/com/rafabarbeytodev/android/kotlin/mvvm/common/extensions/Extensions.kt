package com.rafabarbeytodev.android.kotlin.mvvm.common.extensions

import android.app.Activity
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide


/** A diferencia de una función normal, al ser una función de extensión lleva la clase
 * de la que va a extender primero (String), seguido de un punto y el nombre de tu función.
 *
 * Cuando usamos una función de extensión, la expresión this tendrá el contenido de ficha función,
 * es decir si la función sale de un String, this contendrá un String, si por ejemplo la función
 * sale de un drawable, this será un drawable y así siempre*/
class Extensions {

    /** Comprobacion de nulos*/
    fun Any?.isNull() = this == null

    /**Simplificar TOAST*/
    fun Activity.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, text, duration).show()
    }

    /** Recuperar un color*/
    fun Activity.color(@ColorRes color: Int) = ContextCompat.getColor(this, color)

    /** Cargar URL en Kotlin con Glide */
    fun ImageView.load(url: String) {
        if (url.isNotEmpty()) {
            Glide.with(this.context).load(url).into(this)
        }
    }
}