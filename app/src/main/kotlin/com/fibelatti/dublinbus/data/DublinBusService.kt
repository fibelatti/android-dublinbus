package com.fibelatti.dublinbus.data

import com.fibelatti.dublinbus.data.models.StopInformation
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface DublinBusService {
    @GET("realtimebusinformation")
    fun getByStopId(@Query("stopid") stopId: Int): Observable<StopInformation>

    companion object Factory {
        private val BASE_URL = "https://data.dublinked.ie/cgi-bin/rtpi/"

        fun create(): DublinBusService {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()

            return retrofit.create(DublinBusService::class.java)
        }
    }
}