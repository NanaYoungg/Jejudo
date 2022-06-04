package com.example.teamjejudo.screen.festival

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.teamjejudo.NearInfoData
import com.example.teamjejudo.R
import com.example.teamjejudo.data.NearDetailInfo
import com.example.teamjejudo.data.NearInfo
import com.example.teamjejudo.databinding.FragmentFestivalDetailBinding
import com.example.teamjejudo.databinding.FragmentNearTourDetailBinding
import com.example.teamjejudo.retrofit.Key
import com.example.teamjejudo.retrofit.RetrofitClass
import retrofit2.Call
import retrofit2.Response
import java.net.URLDecoder

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FestivalNearTourDetailFragment : Fragment() {

    private var _binding: FragmentNearTourDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNearTourDetailBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("-------------------------------여기까지 옴!" + arguments?.getString("contentid") + ", " + arguments?.getString("title") + ", " + arguments?.getString("imageurl"))

        _binding!!.neartourdetailTitletext.text = arguments?.getString("title")
        _binding!!.neartourdetailLocatetext.text = arguments?.getString("addr1")
        Glide.with(this).load(arguments?.getString("imageurl")).into(_binding!!.neartourdetailImage)

        GetNearTourDetail(arguments?.getString("contentid")!!)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun GetNearTourDetail(contentid:String)
    {
        val retrofit = RetrofitClass().api.getDetailCommon( URLDecoder.decode(Key, "UTF-8"), "AND", "App", "1",  "1000", "Y", contentid, "json")
        retrofit.enqueue(object : retrofit2.Callback<NearDetailInfo>{
            override fun onResponse(call: Call<NearDetailInfo>, response: Response<NearDetailInfo>) {
                //festival.addAll(response.body()!!.response.body.items.item)
                //binding.rvFestival.adapter?.notifyDataSetChanged()
                var overview: String = response.body()!!.response.body.items.item.overview
                overview = overview.replace("<br>", "")
                println("성공-----------------------$overview")

                _binding!!.neartourdetailOverviewtext.text = overview
            }

            override fun onFailure(call: Call<NearDetailInfo>, t: Throwable) {
                println("실패-----------------------")
                t.printStackTrace()
            }

        })

    }
}