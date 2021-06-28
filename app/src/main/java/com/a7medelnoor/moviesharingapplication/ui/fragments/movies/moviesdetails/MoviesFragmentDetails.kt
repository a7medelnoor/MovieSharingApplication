package com.a7medelnoor.moviesharingapplication.ui.fragments.movies.moviesdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a7medelnoor.moviesharingapplication.R

class MoviesFragmentDetails : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_fragmnet_details, container, false)
    }

}