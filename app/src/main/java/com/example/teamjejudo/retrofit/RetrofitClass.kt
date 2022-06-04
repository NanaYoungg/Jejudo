package com.example.teamjejudo.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

const val KEY = "RfOWqUL5%2FWYn34M9dwfN317UuV8MR1dDhVG2TakLes3hWa2Yb2qq3JH99qZIZxuFjElGy3hUEbo67q3K3e0sxw%3D%3D"
const val BASE_URL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/"

class RetrofitClass {
    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create()).build()

    var api : UserApi = retrofit.create(UserApi::class.java)
}