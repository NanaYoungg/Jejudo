package com.example.teamjejudo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.databinding.CellFestivalBinding
import timber.log.Timber


class FestivalAdapter : RecyclerView.Adapter<FestivalAdapter.MyViewHolder>() {
    var datalist = mutableListOf<Festival>()

    inner class MyViewHolder(private val binding: CellFestivalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(festival: Festival) {
            binding.tvFestivalTitle.text = festival.festivalTitle
            binding.tvFestivalArea.text = festival.festivalArea.toString()
        }
    }


    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            CellFestivalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])
    }
}


//class FestivalAdapter(private val festivalData: List<Festival>, context: Context) :
//    RecyclerView.Adapter<FestivalAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FestivalAdapter.ViewHolder {
//        Timber.d("뷸홀더뷸홀더뷸홀더뷸홀더뷸홀더뷸홀더뷸홀더")
//        val binding =
//            CellFestivalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: FestivalAdapter.ViewHolder, position: Int) {
//        holder.bind(festivalData[position])
//    }
//
//    override fun getItemCount(): Int = festivalData.size
//
//    inner class ViewHolder(private val binding: CellFestivalBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(festival: Festival) {
//            binding.tvFestivalTitle.text = festival.festivalTitle
//            binding.tvFestivalArea.text = festival.festivalArea.toString()
////            binding.tvFestivalDate.text = festival.startDate + " ~ " + festival.endDate
//        }
//    }
//}
