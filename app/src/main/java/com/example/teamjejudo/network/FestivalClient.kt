package com.example.teamjejudo.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FestivalClient {

//    private val BASE_URL: String = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/"
//
//    val getClient: FestivalInterface
//        get() {
//
//            val gson = GsonBuilder()
//                .setLenient()
//                .create()
//
//            //Http 통신 로그 기록
//            val interceptor = HttpLoggingInterceptor()
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//
//            val retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)                                       //네트워크 요청할 서버
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create(gson))  //어떤 Converter를 이용하여 데이터를 파싱할건지
//                .build()                                                 //실질적으로 Retrofit 객체를 만들어 반환
//
//            return retrofit.create(FestivalInterface::class.java)
//
//        }

}