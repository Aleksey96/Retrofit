package com.alexey.retrofit

import io.reactivex.Observable
import retrofit2.http.GET

interface ServiceApi {
   @GET("forecast/")
   fun getWeatherCity():Observable<List<ServerResponse>>
}