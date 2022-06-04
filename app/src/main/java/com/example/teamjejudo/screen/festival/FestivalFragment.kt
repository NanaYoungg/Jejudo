package com.example.teamjejudo.screen.festival

import android.app.ProgressDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamjejudo.adapter.FestivalAdapter
import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.databinding.FragmentFestivalBinding
import com.example.teamjejudo.retrofit.KEY
import com.example.teamjejudo.retrofit.RetrofitClass
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import java.net.URLDecoder
import java.time.LocalDateTime


class FestivalFragment : Fragment() {

    private var _binding: FragmentFestivalBinding? = null
    private val binding get() = _binding!!
    lateinit var progressDialog: ProgressDialog
    private lateinit var adapter: FestivalAdapter

    private val festival = mutableListOf<Festival.Response.Body.Items.Item>()

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

        //통신 로딩
        progressDialog = ProgressDialog(context)
        progressDialog.setTitle("Loading")
        progressDialog.setCancelable(false)
        progressDialog.show()
        getFestivalData()
    }

    private fun initFestivalAdapter() {
        val adapter = FestivalAdapter() //어댑터 객체 만듦
        adapter.festivalList = festival //데이터 넣어줌
        binding.rvFestival.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.rvFestival.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) //레이아웃 매니저 연결
    }

    private fun getFestivalData() {
        val retrofit = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            RetrofitClass().api.getFestivals(
                URLDecoder.decode(KEY, "UTF-8"),
                "AND",
                "App",
                LocalDateTime.now().toString(),
                "json"
            )
        } else {
            TODO("VERSION.SDK_INT < O")
        }

        retrofit.enqueue(object : retrofit2.Callback<Festival> {
            override fun onResponse(call: Call<Festival>, response: Response<Festival>) {
//                val formatter = SimpleDateFormat("yyyy-MM-dd")
//                val startDateFormat = formatter.parse(LocalDateTime.now())
                //TODO: 예외처리
//                if (festival. != null && festival)
//                if (festival.map { it.eventenddate }.map { it } <= LocalDateTime.now())
                response.body()?.response?.body?.items?.let { festival.addAll(it.item) }
                progressDialog.dismiss()
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