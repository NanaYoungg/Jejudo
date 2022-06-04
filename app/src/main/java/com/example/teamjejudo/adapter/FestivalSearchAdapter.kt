package com.example.teamjejudo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.teamjejudo.R
import com.example.teamjejudo.data.Festival
import com.example.teamjejudo.databinding.CellFestivalForsearchBinding
import com.example.teamjejudo.viewmodel.CellFestivalForSearchViewModel
import java.util.*

class FestivalSearchAdapter:
    ListAdapter<Festival, FestivalSearchAdapter.ViewHolder>(diffUtil), Filterable {

    private var list = mutableListOf<Festival>()

    inner class ViewHolder(private val binding:CellFestivalForsearchBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(items: Festival){
            with(binding){
                viewModel = CellFestivalForSearchViewModel(items)
                executePendingBindings()
            }
        }

        init{
            binding.root.setOnClickListener { view->
                view.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val binding = CellFestivalForsearchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Festival>() {
            override fun areContentsTheSame(oldItem: Festival, newItem: Festival) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Festival, newItem: Festival) =
                oldItem == newItem
        }
    }

    fun setData(list: MutableList<Festival>?){
        this.list = list!!
        submitList(list)
    }

    override fun getFilter(): Filter {
        return SearchFilter
    }

    private val SearchFilter : Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {

            val filteredList: ArrayList<Festival> = ArrayList()
            if (constraint == null || constraint.length == 0) {
                filteredList.addAll(list)
            } else {
                val filterPattern = constraint.toString().lowercase().trim { it <= ' '}

                for (item in list) {
                    if(item.festivalTitle.contains(filterPattern)){
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            submitList(results.values as MutableList<Festival>)
        }
    }
}