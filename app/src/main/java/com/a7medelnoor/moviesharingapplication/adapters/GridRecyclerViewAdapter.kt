package com.a7medelnoor.moviesharingapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.moviesharingapplication.databinding.ItemMovieBinding
import com.a7medelnoor.moviesharingapplication.model.Movies
import com.a7medelnoor.moviesharingapplication.model.Results
import com.a7medelnoor.moviesharingapplication.util.MoviesDiffUtill

class GridRecyclerViewAdapter : RecyclerView.Adapter<GridRecyclerViewAdapter.MovieViewHolder>() {
    var movies = emptyList<Results>()
    class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieBinding: Results){
           binding.result = movieBinding
          binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): MovieViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
                return MovieViewHolder(binding)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent)
    }


    override fun getItemCount(): Int {
        return movies.size
    }


    fun setData(newData: Movies) {
        val recipesDiffUtil = MoviesDiffUtill(movies, newData.results)
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        movies = newData.results
        diffUtilResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovies = movies[position]
           holder.bind(currentMovies)

    }

}