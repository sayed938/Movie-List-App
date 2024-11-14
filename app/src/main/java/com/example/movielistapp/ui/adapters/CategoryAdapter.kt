package com.example.movielistapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movielistapp.R


class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private lateinit var categoryList: List<String>

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.categoryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.category_recycler_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        setMovieList(listOf("Popular", "Top Rated", "Now Playing", "Upcoming"))
        holder.categoryName.text = categoryList[position]

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setMovieList(categoryList: List<String>) {
        this.categoryList = categoryList
        notifyDataSetChanged()
    }

}