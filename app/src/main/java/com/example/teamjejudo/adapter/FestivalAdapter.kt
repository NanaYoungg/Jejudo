package com.example.teamjejudo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.databinding.CellFestivalBinding


class FestivalAdapter : RecyclerView.Adapter<FestivalAdapter.MyViewHolder>() {
    var festivalList = mutableListOf<Festival>()

    inner class MyViewHolder(private val binding: CellFestivalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(festival: Festival) {
            binding.tvFestivalTitle.text = festival.festivalTitle
            binding.tvFestivalArea.text = festival.festivalArea.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            CellFestivalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = festivalList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(festivalList[position])
    }
}