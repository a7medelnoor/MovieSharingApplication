package com.a7medelnoor.moviesharingapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.moviesharingapplication.R
import com.a7medelnoor.moviesharingapplication.databinding.ItemMovieBinding
import com.a7medelnoor.moviesharingapplication.databinding.ItemPlaylist1TitleBinding
import com.a7medelnoor.moviesharingapplication.model.GridRecyclerViewItem

class GridRecyclerViewAdapter : RecyclerView.Adapter<GridRecyclerViewHolder>() {
    var items = listOf<GridRecyclerViewItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridRecyclerViewHolder {
        return when (viewType) {
            R.layout.item_playlist1_title -> GridRecyclerViewHolder.TitleViewHolder(
                ItemPlaylist1TitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_movie -> GridRecyclerViewHolder.MovieViewHolder(
                ItemMovieBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")

        }
    }

    override fun onBindViewHolder(holder: GridRecyclerViewHolder, position: Int) {
        when (holder) {
            is GridRecyclerViewHolder.TitleViewHolder -> holder.bind(items[position] as GridRecyclerViewItem.Title)
            is GridRecyclerViewHolder.MovieViewHolder -> holder.bind(items[position] as GridRecyclerViewItem.Movies)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is GridRecyclerViewItem.Title -> R.layout.item_playlist1_title
            is GridRecyclerViewItem.Movies -> R.layout.item_movie
        }
    }

}