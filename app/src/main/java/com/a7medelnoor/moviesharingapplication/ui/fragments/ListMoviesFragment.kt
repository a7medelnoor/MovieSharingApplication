package com.a7medelnoor.moviesharingapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.a7medelnoor.moviesharingapplication.R
import com.a7medelnoor.moviesharingapplication.databinding.FragmentMoviesBinding
import com.a7medelnoor.moviesharingapplication.databinding.FragmentMoviesListBinding
import com.a7medelnoor.moviesharingapplication.ui.fragments.favorites.FavoritesFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

class ListMoviesFragment : Fragment(R.layout.fragment_movies_list) {
    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentMoviesListBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}