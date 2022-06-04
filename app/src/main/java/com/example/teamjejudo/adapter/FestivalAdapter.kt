package com.example.teamjejudo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.teamjejudo.R
import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.databinding.CellFestivalBinding


class FestivalAdapter : RecyclerView.Adapter<FestivalAdapter.ViewHolder>() {
    var festivalList = mutableListOf<Festival.Response.Body.Items.Item>()

    inner class ViewHolder(private val binding: CellFestivalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(festival: Festival.Response.Body.Items.Item) {
            binding.tvFestivalTitle.text = festival.title
            binding.tvFestivalArea.text = festival.addr1
            binding.tvFestivalDate.text = "${festival.eventstartdate} ~ ${festival.eventenddate}"
            Glide.with(itemView.context).load(festival.firstimage).into(binding.ivFestivalRepresent)


            binding.clFestival.setOnClickListener {
                val bundle = bundleOf(
                    "title" to festival.title,
                    "area" to festival.addr1,
                    "photo" to festival.firstimage,
                    "date" to "${festival.eventstartdate} ~ ${festival.eventenddate}",
                    "address" to festival.firstimage + " " + festival.firstimage,
                    "tel" to festival.tel
                )
                itemView.findNavController()
                    .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
            }
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

    }
}