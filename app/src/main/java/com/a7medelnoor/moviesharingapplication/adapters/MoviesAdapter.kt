package com.a7medelnoor.moviesharingapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.moviesharingapplication.databinding.MovieItemCardBinding
import com.a7medelnoor.moviesharingapplication.model.Movies
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
internal class MoviesAdapter(private var moviesList: List<Movies>)  :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private  var binding: MovieItemCardBinding? = null
   // internal inner class MoviesViewHolder(itemCardBinding: MovieItemCardBinding): RecyclerView.ViewHolder(itemCardBinding.root)
    internal inner class MoviesViewHolder(itemCardBinding: MovieItemCardBinding): RecyclerView.ViewHolder(itemCardBinding.root)
    private val differCallback = object :
        DiffUtil.ItemCallback<Movies>() {
        override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem.video_id == newItem.video_id
        }

        override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        binding = MovieItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MoviesViewHolder(binding!!)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val currentMovie = differ.currentList[position]

        holder.itemView.apply {


            Glide.with(this)
                .load(currentMovie.pictures)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding?.moviesImageView!!)

            binding?.moviesNameTextview?.text = currentMovie.name


        }
//            .setOnClickListener { mView ->
//            val direction = MoviesFragmentDirections
//                .actionMoviesFragmentToMoviesFragmentDetails()
//            mView.findNavController().navigate(direction)
//        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}