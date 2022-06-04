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
import com.example.teamjejudo.data.FestivalEx
import com.example.teamjejudo.data.Item
import com.example.teamjejudo.databinding.CellFestivalForsearchBinding
import com.example.teamjejudo.screen.festival.FestivalFragmentDirections
import com.example.teamjejudo.viewmodel.CellFestivalForSearchViewModel
import java.util.*

class FestivalSearchAdapter:
    ListAdapter<Item, FestivalSearchAdapter.ViewHolder>(diffUtil), Filterable {

    private var list = mutableListOf<Item>()

    inner class ViewHolder(private val binding:CellFestivalForsearchBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(items: Item){
            with(binding){
                viewModel = CellFestivalForSearchViewModel(items)
                executePendingBindings()
            }
        }

        init{
            binding.root.setOnClickListener { view->
                val direction = FestivalFragmentDirections.actionFirstFragmentToSecondFragment(binding.viewModel.contentid)
                view.findNavController().navigate(direction)
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
        val diffUtil = object : DiffUtil.ItemCallback<Item>() {
            override fun areContentsTheSame(oldItem: Item, newItem: Item) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Item, newItem: Item) =
                oldItem == newItem
        }
    }

    fun setData(list: MutableList<Item>?){
        this.list = list!!
        submitList(list)
    }

    override fun getFilter(): Filter {
        return SearchFilter
    }

    private val SearchFilter : Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {

            val filteredList: ArrayList<Item> = ArrayList()
            if (constraint == null || constraint.length == 0) {
                filteredList.addAll(list)
            } else {
                val filterPattern = constraint.toString().lowercase().trim { it <= ' '}

                for (item in list) {
                    if(item.title.contains(filterPattern)){
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            submitList(results.values as MutableList<Item>)
        }
    }
}