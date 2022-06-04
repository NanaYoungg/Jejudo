package com.example.teamjejudo.screen.festival

import android.app.ProgressDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.teamjejudo.R
import com.example.teamjejudo.adapter.FestivalSearchAdapter
import com.example.teamjejudo.databinding.FragmentFestivalBinding
import com.example.teamjejudo.viewmodel.FestivalViewModel


class FestivalFragment : Fragment() {

    private var _binding: FragmentFestivalBinding? = null

    private val binding get() = _binding!!

    lateinit var progressDialog: ProgressDialog
    private val viewmodel:FestivalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val searchAdapter = FestivalSearchAdapter()

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

        viewmodel.getFestivalData(progressDialog)
        viewmodel.festivals.observe(viewLifecycleOwner){
            searchAdapter.setData(it)
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
        //binding.rvFestival.adapter = FestivalAdapter(festival, requireContext())
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