package com.example.teamjejudo.screen.festival

import android.app.ProgressDialog
import android.hardware.lights.LightsManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamjejudo.R
import com.example.teamjejudo.adapter.FestivalAdapter
import com.example.teamjejudo.adapter.FestivalSearchAdapter
import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.data.FestivalEx
import com.example.teamjejudo.data.Item
import com.example.teamjejudo.databinding.FragmentFestivalBinding
import com.example.teamjejudo.retrofit.RetrofitClass
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import java.net.URLDecoder
import java.util.ArrayList

class FestivalFragment : Fragment() {

    private var _binding: FragmentFestivalBinding? = null
    private var festival = ArrayList<FestivalEx>()

    private val binding get() = _binding!!

    lateinit var progressDialog: ProgressDialog
    private val festivalm = mutableListOf<Item>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchAdapter = FestivalSearchAdapter()
        // 테스트용 임시 데이터
//        val festivalEx = arrayListOf<FestivalEx>(
//            FestivalEx(festivalTitle = "곰연어축제"),
//            FestivalEx(festivalTitle = "곰연어발바닥축제"),
//            FestivalEx(festivalTitle = "곰희망축제"),
//        )

        _binding = FragmentFestivalBinding.inflate(inflater, container, false)
        binding.apply {
            binding.rvFestivalForsearch.adapter = searchAdapter
            binding.rvFestivalForsearch.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setEtListeners(etSearchbar, adapter = searchAdapter,parentview)
        }

        progressDialog = ProgressDialog(context)
        progressDialog.setTitle("Loading")
        progressDialog.setCancelable(false)
        progressDialog.show()
        getFestivalData()

        searchAdapter.setData(festivalm)
        return binding.root
    }


    private fun getFestivalData() {
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
                response.body()?.response?.body?.items?.let { festivalm.addAll(it as List<Item>) }
                progressDialog.dismiss()
                println(response.body()?.response?.body?.items?.item)
                Log.d("retrofitFesFrag","${response.body()?.response?.body?.items?.item}")
            }

            override fun onFailure(call: Call<Festival>, t: Throwable) {
                Log.d("retrofitFesFrag","${t.message}")
                Timber.e("실패 ")
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFestivalAdapter()

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun initFestivalAdapter() {
        binding.rvFestival.adapter = FestivalAdapter(festival, requireContext())
        binding.rvFestival.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setEtListeners(et:EditText,adapter:FestivalSearchAdapter,parentview:View){
        et.setOnFocusChangeListener { v, hasFocus ->
            binding.isFocused = hasFocus
        }

        et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int,count: Int, after: Int) {}
            override fun onTextChanged(
                str: CharSequence, start: Int,
                before: Int, count: Int,
            ) {
                adapter.filter.filter(str)
            }
        })

        parentview.setOnTouchListener { view, motionEvent ->
            et.clearFocus()
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}