package com.example.teamjejudo.retrofit

import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.data.NearDetailInfo
import com.example.teamjejudo.data.NearInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("searchFestival")
    fun getFestivals(
        @Query("serviceKey") serviceKey : String,
        @Query("MobileOS") mobileOS : String,
        @Query("MobileApp") mobileApp : String,
        @Query("eventStartDate") eventStartDate : String,
        @Query("_type") type: String
    ) : Call<Festival>


    @GET("areaBasedList")
    fun getAreaBasedList(
        @Query("serviceKey") serviceKey : String,
        @Query("MobileOS") mobileOS : String,
        @Query("MobileApp") mobileApp : String,
        @Query("areaCode") areaCode : String,
        @Query("numOfRows") numOfRows : String,
        @Query("arrange") arrange : String,
        @Query("contentTypeId") contentTypeId : String,
        @Query("_type") type: String
    ) : Call<NearInfo>

    @GET("detailCommon")
    fun getDetailCommon(
        @Query("serviceKey") serviceKey : String,
        @Query("MobileOS") mobileOS : String,
        @Query("MobileApp") mobileApp : String,
        @Query("pageNo") pageNo : String,
        @Query("numOfRows") numOfRows : String,
        @Query("overviewYN") overviewYN : String,
        @Query("contentId") contentId : String,
        @Query("_type") type: String
    ) : Call<NearDetailInfo>


}