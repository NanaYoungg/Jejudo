package com.example.teamjejudo.screen.festival

import android.hardware.lights.LightsManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.teamjejudo.NearInfoData
import com.example.teamjejudo.NearTourAdapter
import com.example.teamjejudo.R
import com.example.teamjejudo.adapter.FestivalAdapter
import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.data.NearInfo
import com.example.teamjejudo.databinding.FragmentFestivalBinding
import com.example.teamjejudo.retrofit.Key
import com.example.teamjejudo.retrofit.RetrofitClass
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import java.net.URLDecoder
import java.util.ArrayList

class FestivalFragment : Fragment() {

    private var _binding: FragmentFestivalBinding? = null
    private var festival = ArrayList<Festival>()

    private val binding get() = _binding!!
    val areaCodeDic = hashMapOf("서울" to 1, "인천" to 2,"대전" to 3,"대구" to 4,"광주" to 5,
            "부산" to 6,"울산" to 7,"세종특별자치시" to 8,"경기도" to 31,"강원도" to 32,"충청북도" to 33,
            "충청남도" to 34,"경상북도" to 35,"경상남도" to 36,"전라북도" to 37,"전라남도" to 38)
    var nearInfoDatas = arrayListOf<NearInfoData>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFestivalBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFestivalAdapter()

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.neartourRecyclerview.layoutManager =  LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.neartourRecyclerview.adapter = NearTourAdapter(nearInfoDatas)
        GetNearTour("1")


        // 리사이클러 뷰 스냅헬퍼
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.neartourRecyclerview)

        binding.neartourRecyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            var currentPosition = RecyclerView.NO_POSITION

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (recyclerView.layoutManager != null) {
                    val view = snapHelper.findSnapView(recyclerView.layoutManager)!!
                    val position = recyclerView.layoutManager!!.getPosition(view)

                    if (currentPosition != position) {
                        currentPosition = position
                    }
                }
            }
        })
    }

    private fun initFestivalAdapter() {
        binding.rvFestival.adapter = FestivalAdapter(festival, requireContext())
        binding.rvFestival.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        Timber.d("sdfsdfsdfsdfsdfsdf")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun GetNearTour(areaCode: String)
    {
        val retrofit = RetrofitClass().api.getAreaBasedList( URLDecoder.decode(Key, "UTF-8"), "AND", "App", areaCode,  "1000", "O", "12", "json")
        retrofit.enqueue(object : retrofit2.Callback<NearInfo>{
            override fun onResponse(call: Call<NearInfo>, response: Response<NearInfo>) {
                //festival.addAll(response.body()!!.response.body.items.item)
                //binding.rvFestival.adapter?.notifyDataSetChanged()
                println("성공-----------------------")
                for(item in response.body()!!.response.body.items.item)
                {
                    if(item.firstimage == null) continue
                    val nearInfoData = NearInfoData(item.title, item.firstimage, item.addr1, item.contentid.toString(), "")
                    nearInfoDatas.add(nearInfoData)
                }

                binding.neartourRecyclerview.adapter?.notifyDataSetChanged()
                println(nearInfoDatas.count())

            }

            override fun onFailure(call: Call<NearInfo>, t: Throwable) {
                println("실패-----------------------")
                t.printStackTrace()
            }

        })

    }
}