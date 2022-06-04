package com.example.teamjejudo.network

import com.example.teamjejudo.data.Festival
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface FestivalInterface {

// http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival

    @GET("searchFestival")
    fun getFestival(
        @Header("token") token: String?,
    ): Call<List<Festival>>

    companion object {
//        const val KEY_FESTIVAL
    }
}