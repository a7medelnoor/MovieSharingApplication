package com.a7medelnoor.moviesharingapplication.ui.fragments.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.a7medelnoor.moviesharingapplication.R
import com.a7medelnoor.moviesharingapplication.adapters.ViewPagerAdapter
import com.a7medelnoor.moviesharingapplication.databinding.FragmentMoviesBinding
import com.a7medelnoor.moviesharingapplication.ui.fragments.favorites.FavoritesFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_movies.view.*

class MoviesFragment : Fragment(R.layout.fragment_movies) {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragmentAdapter = ViewPagerAdapter(requireFragmentManager())
        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)


//        var adapter = ViewPagerAdapter(requireFragmentManager(), lifecycle)
//
//        binding.viewPager.adapter = adapter
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//
//            when (position) {
//
//                0 -> {
//                    tab.text = "GRID"
//                }
//                1 -> {
//                    tab.text = "LIST"
//                }
//            }
//
//
//        }.attach()


//        fragment = MoviesFragment()
//        fragmentTransaction = requireFragmentManager()!!.beginTransaction()
//        fragmentTransaction!!.replace(R.id.frameLayout, fragment!!)
//        fragmentTransaction!!.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//        fragmentTransaction!!.commit()
//        binding.tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                // creating cases for fragment
//                when (tab.position) {
//                    0 -> fragment = MoviesFragment()
//                    1 -> fragment = SearchMovieFragment()
//                }
//                val fm = childFragmentManager
//                val ft = fm.beginTransaction()
//                ft.replace(R.id.frameLayout, fragment!!)
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                ft.commit()
//            }
//            override fun onTabUnselected(tab: TabLayout.Tab) {
//
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab) {
//
//            }
//        })

    }

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