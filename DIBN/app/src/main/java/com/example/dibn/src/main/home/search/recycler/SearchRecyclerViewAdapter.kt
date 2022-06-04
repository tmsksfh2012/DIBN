package com.example.dibn.src.main.home.search.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.dibn.R
import com.example.dibn.src.main.home.recycler.HomeRecyclerViewHolder
import com.example.dibn.src.main.home.retrofit.ItemData
import com.example.dibn.src.main.home.search.SearchFragment

class SearchRecyclerViewAdapter(var items: SearchFragment.itemListAdapterToList, itemList: ArrayList<ItemData>)
    : RecyclerView.Adapter<SearchRecyclerViewHolder>(), Filterable{

    lateinit var homeRecyclerViewHolder : HomeRecyclerViewHolder
    private var unFilteredList = itemList
    private var filteredList = itemList


    lateinit var searchRecyclerViewHolder : SearchRecyclerViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecyclerViewHolder {
        searchRecyclerViewHolder = SearchRecyclerViewHolder(
            parent.context,
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_search, parent, false)
        )
        return searchRecyclerViewHolder
    }

    override fun onBindViewHolder(holder: SearchRecyclerViewHolder, position: Int) {
        holder.bindWithView(filteredList[position])
        holder.itemView.setOnClickListener {
            val item = filteredList[position]
            items.getItemId(item)
        }
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint.toString()
                filteredList = if (charString.isEmpty()) {
                    unFilteredList
                } else {
                    val filteringList = ArrayList<ItemData>()
                    for (item in unFilteredList) {
                        if (item.category == charString) filteringList.add(item)
                    }
                    filteringList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredList

                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                filteredList = results.values as ArrayList<ItemData>
                notifyDataSetChanged()
            }
        }
    }
}