package com.rafabarbeytodev.android.kotlin.mvvm.data.model

import com.google.gson.annotations.SerializedName

/**Primer paso para la implementación del MVMM, crear el modelo de datos de nuestra aplicación*/

data class QuoteModel (
    /** Entrecomillado el nombre exacto del campo facilitado por el proveedor
     * despues el nombre que deseemos darle*/

    @SerializedName("quote") var quote:String,
    @SerializedName("author") val author:String
    )
