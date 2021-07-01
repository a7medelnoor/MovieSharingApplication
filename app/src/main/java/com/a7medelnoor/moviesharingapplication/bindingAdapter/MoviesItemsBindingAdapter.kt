package com.a7medelnoor.moviesharingapplication.bindingAdapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.a7medelnoor.moviesharingapplication.R

class MoviesItemsBindingAdapter {
  companion object {
      @BindingAdapter("loadImageFromUrl")
      @JvmStatic
      fun loadImageFromUrl(imageView: ImageView, imageUrl: String) {
          imageView.load(imageUrl) {
              crossfade(600)
              error(R.drawable.ic_error_placeholder)
          }
      }
      @BindingAdapter("setMovieName")
      @JvmStatic
      fun setMovieName(textView: TextView, name: String){
          textView.text = name
      }
  }
}