package com.shlokIT.colorpredictiongame.Network

import com.shlokIT.colorpredictiongame.Pojo.CityData
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    //get Perticular City Data
    @GET("v1/current.json?key=4dd79c02aff94ebab1a190013232512&q")
    fun GetSelectedCityData(@Query("") value: String): Call<CityData>
}