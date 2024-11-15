package com.example.movielistapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.MovieModel
import com.example.movielistapp.R
import com.example.movielistapp.ui.AppData.AppData
import com.squareup.picasso.Picasso

class MainMoviesAdapter : RecyclerView.Adapter<MainMoviesAdapter.MainViewHolder>() {
    private var movieList: List<MovieModel> = listOf(
        MovieModel(
            true,
            "",
            listOf(0),
            0,
            "",
            "",
            "",
            4.1,
            "/l1175hgL5DoXnqeZQCcU3eZIdhX.jpg",
            "", "", false, 2.2, 5
        ), MovieModel(
            true,
            "",
            listOf(0),
            0,
            "",
            "",
            "",
            4.1,
            "/lqoMzCcZYEFK729d6qzt349fB4o.jpg",
            "", "", false, 2.2, 5
        ), MovieModel(
            true,
            "",
            listOf(0),
            0,
            "",
            "",
            "",
            4.1,
            "/2cxhvwyEwRlysAmRH4iodkvo0z5.jpg",
            "", "", false, 2.2, 5
        ), MovieModel(
            true,
            "",
            listOf(0),
            0,
            "",
            "",
            "",
            4.1,
            "/cdqLnri3NEGcmfnqwk2TSIYtddg.jpg",
            "", "", false, 2.2, 5
        ), MovieModel(
            true,
            "",
            listOf(0),
            0,
            "",
            "",
            "",
            4.1,
            "/zw4kV7npGtaqvUxvJE9IdqdFsNc.jpg",
            "", "", false, 2.2, 5
        )
    )

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImg: ImageView = itemView.findViewById(R.id.movieImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.main_movies_item, parent, false)
        return MainViewHolder(view)
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        setMovieImg(holder.movieImg, position)
        holder.movieImg.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = movieList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setMovieList(movieList: List<MovieModel>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    private fun setMovieImg(movieImg: ImageView, position: Int) {
        Picasso.get().load(AppData.baseImgUrl + movieList[position].posterPath)
            .into(movieImg)
    }
}