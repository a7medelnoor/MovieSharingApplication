package com.a7medelnoor.moviesharingapplication.ui.fragments.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.a7medelnoor.moviesharingapplication.R
import com.a7medelnoor.moviesharingapplication.databinding.FragmentMoviesBinding
import com.a7medelnoor.moviesharingapplication.ui.fragments.favorites.FavoritesFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

class MoviesFragment : Fragment(R.layout.fragment_movies) {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    fun TabLayout.setupWithViewPager(viewPager: ViewPager2, labels: List<String>) {

        if (labels.size != viewPager.adapter?.itemCount)
            throw Exception("The size of list and the tab count should be equal!")

        TabLayoutMediator(this, viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = labels[position]
            }).attach()
    }

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

    private fun setupTabBar() {
        val adapter = FragmentPagerItemAdapter(
            childFragmentManager,
            FragmentPagerItems.with(activity)
                .add("GRID", MoviesFragment::class.java)
                .add("LIST", FavoritesFragment::class.java)
                .create()
        )
//       viewPagerAdapter =ViewPagerAdapter(childFragmentManager)
//        binding.registerViewpager.adapter = adapter
//        binding.registerTabs.setupWithViewPager(binding.registerViewpager)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}