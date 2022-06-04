package com.example.teamjejudo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.databinding.CellFestivalBinding


class FestivalAdapter : RecyclerView.Adapter<FestivalAdapter.ViewHolder>() {
//    var festivalList = mutableListOf<Festival>()
    var festivalList = mutableListOf<Festival.Response.Body.Items.Item>()

    inner class ViewHolder(private val binding: CellFestivalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(festival: Festival.Response.Body.Items.Item) {
            binding.tvFestivalTitle.text = festival.title
            binding.tvFestivalArea.text = festival.addr1
            Glide.with(itemView.context).load(festival.firstimage).into(binding.ivFestivalRepresent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CellFestivalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = festivalList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(festivalList[position])
        println("ddddddddddddddddddddddddddddddd ${festivalList[position]}")

    }
}