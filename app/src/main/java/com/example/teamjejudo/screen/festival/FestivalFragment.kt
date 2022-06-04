package com.example.teamjejudo.screen.festival

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

class FestivalFragment : Fragment() {

    private var _binding: FragmentFestivalBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: FestivalAdapter
    private val festival = mutableListOf<Festival>()

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
    }

    private fun initFestivalAdapter() {
        val adapter = FestivalAdapter() //어댑터 객체 만듦
        adapter.festivalList = festival //데이터 넣어줌
        binding.rvFestival.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.rvFestival.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) //레이아웃 매니저 연결
    }

//    fun initializelist() { //임의로 데이터 넣어서 만들어봄
//        with(festival) {
//            add(Festival("test1", 1, "1", "2"))
//            add(Festival("test2", 2, "20", "M"))
//            add(Festival("test3", 3, "20", "M"))
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}