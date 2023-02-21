package com.rafabarbeytodev.android.kotlin.mvvm.data.di

import com.rafabarbeytodev.android.kotlin.mvvm.data.network.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*****
 * Proyect: MVVM
 * Package: com.rafabarbeytodev.android.kotlin.mvvm.data.di
 *
 * Created by Rafael Barbeyto Torrellas on 21/02/2023 at 14:25
 * More info: https://www.linkedin.com/in/rafa-barbeyto/
 *
 * All rights reserved 2023.
 *****/

/**
 * Este módulo nos va a proveer de las dependencias que no se puedan conseguir
 * con @Inject constructor(), que normalmente serán las externas a android, como
 * es retrofit, o clases que tengan interfaces.
 * Se usará la etiqueta @Module, que es la que provee dependencias
 * Con @InstallIn, indicamos el alcance de la instancias generadas por Dagger
 * de forma que cuando muera dicho alcance también lo hará la dependencia
 * Los mas usuales son los niveles de Application, Activity y ViewModel
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton // solo generamos una unica instancia para todas las peticiones
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Esto es necesario ya que la clase ApiService tiene Interfaces
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit):APIService{
            return retrofit.create(APIService::class.java)
    }

}