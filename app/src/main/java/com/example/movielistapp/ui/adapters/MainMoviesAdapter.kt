package com.example.movielistapp.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.MovieModel
import com.example.movielistapp.R
import com.example.movielistapp.ui.appdata.AppData
import com.example.movielistapp.ui.fragment.MainFragmentDirections
import com.squareup.picasso.Picasso

class MainMoviesAdapter(
    private var movieList: List<MovieModel>
) : RecyclerView.Adapter<MainMoviesAdapter.MainViewHolder>() {

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImg: ImageView = itemView.findViewById(R.id.movieImg)
        fun saveArgs(id: String) {
            val action =
                MainFragmentDirections.actionMainFragmentToDetailsFragment(id)

            itemView.findNavController().navigate(action)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.main_movies_item, parent, false)
        return MainViewHolder(view)
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        setMovieImg(holder.movieImg, position)
        holder.movieImg.setOnClickListener {
            holder.saveArgs(movieList[position].id.toString())
        }
    }

    override fun getItemCount(): Int = movieList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setMovieList(movieList: List<MovieModel>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    private fun setMovieImg(movieImg: ImageView, position: Int) {
        Picasso.get().load(AppData.baseImgUrl + movieList[position].poster_path)
            .into(movieImg)
    }


}