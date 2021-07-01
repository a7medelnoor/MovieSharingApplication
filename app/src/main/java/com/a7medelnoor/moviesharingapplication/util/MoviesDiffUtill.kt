package com.a7medelnoor.moviesharingapplication.util

import androidx.recyclerview.widget.DiffUtil
import com.a7medelnoor.moviesharingapplication.model.Results

class MoviesDiffUtill(private val oldList: List<com.a7medelnoor.moviesharingapplication.model.Results>,
                      private val newList: List<Results>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
         return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}