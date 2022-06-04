package com.example.teamjejudo.data

import com.google.gson.annotations.SerializedName

//http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival

data class Festival(
    @SerializedName("title")
    val festivalTitle: String,
    @SerializedName("areacode")
    val festivalArea: Int,
    @SerializedName("eventstartdate")
    val startDate: String,
    @SerializedName("eventenddate")
    val endDate: String,
//    @SerializedName("firstimage2")
//    val thumbnailImage: String
)