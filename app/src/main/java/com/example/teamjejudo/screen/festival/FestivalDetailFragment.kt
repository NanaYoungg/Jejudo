package com.example.teamjejudo.screen.festival

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.teamjejudo.R
import com.example.teamjejudo.databinding.FragmentFestivalDetailBinding

class FestivalDetailFragment : Fragment() {

    private var _binding: FragmentFestivalDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFestivalDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
        binding.apply {
            tvFestivalDetailTitle.text = arguments?.getString("title")
            tvFestivalDetailArea.text = arguments?.getString("area")
//            ivFestivalDetail = arguments?.getString("photo")
            Glide.with(requireContext()).load(arguments?.getString("photo")).into(binding.ivFestivalDetail)


//            "photo" to festival.firstimage,
//            "date" to "${festival.eventstartdate} ~ ${festival.eventenddate}",
//            "address" to festival.firstimage + " " + festival.firstimage,
//            "tel" to festival.tel
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}