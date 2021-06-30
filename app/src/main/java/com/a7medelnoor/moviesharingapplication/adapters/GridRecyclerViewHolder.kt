package com.a7medelnoor.moviesharingapplication.adapters

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.a7medelnoor.moviesharingapplication.databinding.ItemMovieBinding
import com.a7medelnoor.moviesharingapplication.databinding.ItemPlaylist1TitleBinding
import com.a7medelnoor.moviesharingapplication.model.GridRecyclerViewItem
import kotlinx.android.synthetic.main.activity_main.view.*

sealed class GridRecyclerViewHolder(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    class TitleViewHolder(private val binding: ItemPlaylist1TitleBinding): GridRecyclerViewHolder(binding){
        fun bind (title: GridRecyclerViewItem.Title){
            binding.textViewTitle.text = title.title
        }
    }
    class MovieViewHolder(private val binding: ItemMovieBinding) :
        GridRecyclerViewHolder(binding) {
        fun bind(movieBinding: GridRecyclerViewItem.Movies){
            binding.movieImageView.load(movieBinding.movie_thumbnail)
            binding.movieNameTextView.text = movieBinding.movie_name
        }
    }
}