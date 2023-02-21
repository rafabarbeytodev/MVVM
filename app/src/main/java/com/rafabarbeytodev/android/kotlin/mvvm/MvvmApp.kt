package com.rafabarbeytodev.android.kotlin.mvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*****
 * Proyect: MVVM
 * Package: com.rafabarbeytodev.android.kotlin.mvvm
 *
 * Created by Rafael Barbeyto Torrellas on 21/02/2023 at 14:04
 * More info: https://www.linkedin.com/in/rafa-barbeyto/
 *
 * All rights reserved 2023.
 *****/

/**
Esta clase es la primera que se ejcutará cuando se inicie la app.
 Hay que añadir en el Manifiest la entrada android:name=".MvvmApp" en
 el bloque application.
 Con la etiqueta @HiltAndroidApp se genera automáticamente por detrás
 el código necesario
 **/
@HiltAndroidApp
class MvvmApp : Application()
