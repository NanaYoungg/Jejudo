package com.example.teamjejudo.data

import com.example.teamjejudo.room.LikeFestival
import com.google.gson.annotations.SerializedName

//http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival

data class Festival(
    @SerializedName("response")
    val response: Response
) {
    data class Response(
        @SerializedName("body")
        val body: Body,
        @SerializedName("header")
        val header: Header
    ) {
        data class Body(
            @SerializedName("items")
            val items: Items,
            @SerializedName("numOfRows")
            val numOfRows: Int,
            @SerializedName("pageNo")
            val pageNo: Int,
            @SerializedName("totalCount")
            val totalCount: Int
        ) {
            data class Items(
                @SerializedName("item")
                val item: List<Item>
            ) {
                data class Item(
                    @SerializedName("addr1")
                    val addr1: String,
                    @SerializedName("addr2")
                    val addr2: String,
                    @SerializedName("areacode")
                    val areacode: Int,
                    @SerializedName("cat1")
                    val cat1: String,
                    @SerializedName("cat2")
                    val cat2: String,
                    @SerializedName("cat3")
                    val cat3: String,
                    @SerializedName("contentid")
                    val contentid: Int,
                    @SerializedName("contenttypeid")
                    val contenttypeid: Int,
                    @SerializedName("createdtime")
                    val createdtime: Long,
                    @SerializedName("eventenddate")
                    val eventenddate: Int,
                    @SerializedName("eventstartdate")
                    val eventstartdate: Int,
                    @SerializedName("firstimage")
                    val firstimage: String,
                    @SerializedName("firstimage2")
                    val firstimage2: String,
                    @SerializedName("mapx")
                    val mapx: Double,
                    @SerializedName("mapy")
                    val mapy: Double,
                    @SerializedName("mlevel")
                    val mlevel: Int,
                    @SerializedName("modifiedtime")
                    val modifiedtime: Long,
                    @SerializedName("readcount")
                    val readcount: Int,
                    @SerializedName("sigungucode")
                    val sigungucode: Int,
                    @SerializedName("tel")
                    val tel: String,
                    @SerializedName("title")
                    val title: String
                ) {
                    fun toEntity(): LikeFestival {

                        return LikeFestival(
                            addr1,
                            addr2,
                            areacode,
                            cat1,
                            cat2,
                            cat3,
                            contentid,
                            contenttypeid,
                            createdtime,
                            eventenddate,
                            eventstartdate,
                            firstimage,
                            firstimage2,
                            mapx,
                            mapy,
                            mlevel,
                            modifiedtime,
                            readcount,
                            sigungucode,
                            tel,
                            title
                        )
                    }
                }
            }
        }

        data class Header(
            @SerializedName("resultCode")
            val resultCode: String,
            @SerializedName("resultMsg")
            val resultMsg: String
        )
    }
}