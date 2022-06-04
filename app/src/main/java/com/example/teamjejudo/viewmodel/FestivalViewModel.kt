package com.example.teamjejudo.viewmodel

import android.app.ProgressDialog
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.data.Item
import com.example.teamjejudo.retrofit.RetrofitClass
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import java.net.URLDecoder
import java.util.ArrayList

class FestivalViewModel
    : ViewModel() {

    val festivals = MutableLiveData<ArrayList<Item>>()

    fun getFestivalData() {
        val Key = "RfOWqUL5%2FWYn34M9dwfN317UuV8MR1dDhVG2TakLes3hWa2Yb2qq3JH99qZIZxuFjElGy3hUEbo67q3K3e0sxw%3D%3D"
        val retrofit = RetrofitClass().api.getFestivals(
            URLDecoder.decode(Key, "UTF-8"),
            "AND",
            "App",
            "20220604",
            "json"
        )

        retrofit.enqueue(object : retrofit2.Callback<Festival> {
            override fun onResponse(call: Call<Festival>, response: Response<Festival>) {
                val list = ArrayList<Item>()
                response.body()?.response?.body?.items?.let {
                    list.addAll(it.item)
                    festivals.value = list
                }
            }

            override fun onFailure(call: Call<Festival>, t: Throwable) {
                Timber.e("실패 ")
            }
        })
    }

}