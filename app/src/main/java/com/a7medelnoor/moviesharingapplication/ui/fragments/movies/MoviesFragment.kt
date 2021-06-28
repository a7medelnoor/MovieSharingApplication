package com.a7medelnoor.moviesharingapplication.ui.fragments.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.a7medelnoor.moviesharingapplication.R
import com.a7medelnoor.moviesharingapplication.adapters.MoviesAdapter
import com.a7medelnoor.moviesharingapplication.databinding.FragmentMoviesBinding
import com.a7medelnoor.moviesharingapplication.model.Movies
import com.a7medelnoor.moviesharingapplication.ui.fragments.favorites.FavoritesFragment
import com.google.android.material.tabs.TabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems


class MoviesFragment : Fragment(R.layout.fragment_movies) {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentMoviesBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//      setupTabBar()
    }

    private fun setupTabBar() {
        val adapter = FragmentPagerItemAdapter(
            childFragmentManager,
            FragmentPagerItems.with(activity)
                .add("GRID", MoviesFragment::class.java)
                .add("LIST", FavoritesFragment::class.java)
                .create()
        )

//        binding.viewpager.adapter = adapter
//        binding.viewpagertab.setViewPager(binding.viewpager)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}