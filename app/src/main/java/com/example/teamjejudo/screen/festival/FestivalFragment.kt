package com.example.teamjejudo.screen.festival

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
import com.example.teamjejudo.data.FestivalEx
import com.example.teamjejudo.databinding.FragmentFestivalBinding
import timber.log.Timber
import java.util.ArrayList

class FestivalFragment : Fragment() {

    private var _binding: FragmentFestivalBinding? = null
    private var festival = ArrayList<FestivalEx>()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchAdapter = FestivalSearchAdapter()
        val festivalEx = arrayListOf<FestivalEx>(
            FestivalEx(festivalTitle = "dd"),
            FestivalEx(festivalTitle = "연어"),
            FestivalEx(festivalTitle = "곰"),
        )
        _binding = FragmentFestivalBinding.inflate(inflater, container, false)
        binding.apply {
            binding.rvFestivalForsearch.adapter = searchAdapter
            binding.rvFestivalForsearch.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            searchAdapter.setData(festivalEx)
            setEtListeners(etSearchbar, adapter = searchAdapter)
        }
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
        binding.rvFestival.adapter = FestivalAdapter(festival, requireContext())
        binding.rvFestival.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    private fun setEtListeners(et:EditText,adapter:FestivalSearchAdapter){
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}