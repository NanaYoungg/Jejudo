package com.example.teamjejudo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.teamjejudo.screen.festival.FestivalFragment
import com.example.teamjejudo.screen.festival.FestivalFragmentDirections


class NearInfoData(val title:String, val imageUrl:String, val addr1:String, val contentid:String, val overview:String)


class NearTourViewHolder(v: View):RecyclerView.ViewHolder(v)
{
    val neartourtitle_textView = v.findViewById<TextView>(R.id.neartour_title)
    var neartourtitle_imageView = v.findViewById<ImageView>(R.id.neartour_image)
}

class NearTourAdapter(val nearInfoDatas:ArrayList<NearInfoData>) : RecyclerView.Adapter<NearTourViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearTourViewHolder
    {
        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.neartour, parent, false)
        return NearTourViewHolder(cellForRow)
    }

    override fun getItemCount() = nearInfoDatas.size

    override fun onBindViewHolder(holder: NearTourViewHolder, position: Int)
    {
        holder.neartourtitle_textView.text = nearInfoDatas[position].title
        holder.neartourtitle_imageView.clipToOutline = true
        Glide.with(holder.neartourtitle_imageView.context).load(nearInfoDatas[position].imageUrl).into(holder.neartourtitle_imageView)


        holder.neartourtitle_imageView.setOnClickListener { v ->
            val direction = FestivalFragmentDirections.actionFirstFragmentToNearTourDetailFragment(nearInfoDatas[position].title, nearInfoDatas[position].imageUrl, nearInfoDatas[position].contentid, nearInfoDatas[position].addr1)
            v.findNavController().navigate(direction)
            //Toast.makeText(v.context, nearInfoDatas[position].title, Toast.LENGTH_LONG).show()
        }
    }


}