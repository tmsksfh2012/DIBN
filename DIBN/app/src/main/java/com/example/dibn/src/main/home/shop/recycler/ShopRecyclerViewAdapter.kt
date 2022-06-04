package com.example.dibn.src.main.home.recycler

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dibn.R
import com.example.dibn.src.main.home.HomeFragment
import com.example.dibn.src.main.home.retrofit.ItemData
import com.example.dibn.src.main.home.search.recycler.Item
import com.example.dibn.src.main.home.shop.ShopFragment
import java.lang.Integer.parseInt

class ShopRecyclerViewAdapter(var items: ShopFragment.itemListAdapterToList, itemList: ArrayList<ItemData>)
    : RecyclerView.Adapter<ShopRecyclerViewHolder>(), Filterable{

    lateinit var shopRecyclerViewHolder : ShopRecyclerViewHolder
    private var unFilteredList = itemList
    private var filteredList = itemList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopRecyclerViewHolder {
        shopRecyclerViewHolder = ShopRecyclerViewHolder(
            parent.context,
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_search, parent, false)
        )
        return shopRecyclerViewHolder
    }

    override fun onBindViewHolder(holder: ShopRecyclerViewHolder, position: Int) {
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