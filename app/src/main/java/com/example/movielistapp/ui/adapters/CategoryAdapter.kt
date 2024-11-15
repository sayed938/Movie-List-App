package com.example.movielistapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movielistapp.R


class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private var pos:String="Popular"
    private val categoryList: List<String> =
        listOf("Popular", "Top Rated", "Now Playing", "Upcoming")

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.categoryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_recycler_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryName.text = categoryList[position]
        holder.categoryName.setOnClickListener {

            pos = categoryList[position]
        }
        /*if (pos == categoryList[position]) {
            holder.categoryName.textSize = 20F
            holder.categoryName.setShadowLayer(5F, 6F, 6F, R.color.black)

        }
        else{
            holder.categoryName.textSize = 14F
            holder.categoryName.setShadowLayer(0F, 0F, 0F, R.color.black)
        }*/

    }

}