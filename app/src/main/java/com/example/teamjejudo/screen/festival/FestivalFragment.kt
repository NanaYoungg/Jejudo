package com.example.teamjejudo.screen.festival

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamjejudo.R
import com.example.teamjejudo.adapter.FestivalAdapter
import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.databinding.FragmentFestivalBinding
import com.example.teamjejudo.retrofit.KEY
import com.example.teamjejudo.retrofit.RetrofitClass
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import java.net.URLDecoder


class FestivalFragment : Fragment() {

    private var _binding: FragmentFestivalBinding? = null
    private val binding get() = _binding!!
//    private lateinit var adapter: FestivalAdapter
//    private val adapter: FestivalAdapter by lazy { FestivalAdapter() }
    lateinit var progressDialog: ProgressDialog

    //    private val festival = mutableListOf<Festival>()
    private val festival = mutableListOf<Festival.Response.Body.Items.Item>()
    private val festival2 = mutableListOf<Festival>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFestivalBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("ddddddddddddddddddddddddddddddd22222")
        initFestivalAdapter()
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        //통신 로딩
        progressDialog = ProgressDialog(context)
        progressDialog.setTitle("Loading")
        progressDialog.setCancelable(false)
        progressDialog.show()
        getFestivalData()
    }

    private fun initFestivalAdapter() {
        println("dddddd ${festival.size}")
        println("ssss233333333333333332 ${festival2.size}")
        val adapter = FestivalAdapter() //어댑터 객체 만듦
        adapter.festivalList = festival //데이터 넣어줌
        binding.rvFestival.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.rvFestival.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) //레이아웃 매니저 연결
    }

    private fun getFestivalData() {
        val retrofit = RetrofitClass().api.getFestivals(
            URLDecoder.decode(KEY, "UTF-8"),
            "AND",
            "App",
            "20220604",
            "json"
        )
        retrofit.enqueue(object : retrofit2.Callback<Festival> {
            override fun onResponse(call: Call<Festival>, response: Response<Festival>) {
                response.body()?.response?.body?.items?.let { festival.addAll(it.item) }
                progressDialog.dismiss()
                println("test ${response.body()?.response?.body?.items?.item}")

                binding.rvFestival.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Festival>, t: Throwable) {
                Timber.e("실패 ")
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}