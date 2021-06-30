package com.a7medelnoor.moviesharingapplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.a7medelnoor.moviesharingapplication.ui.fragments.ListMoviesFragment
import com.a7medelnoor.moviesharingapplication.ui.fragments.movies.MoviesFragment
import com.a7medelnoor.moviesharingapplication.ui.fragments.movies.grid.GridFragment
import com.a7medelnoor.moviesharingapplication.ui.fragments.movies.list.ListFragment
import com.a7medelnoor.moviesharingapplication.ui.fragments.movies.searchmovie.SearchMovieFragment

class ViewPagerAdapter(
    fm: FragmentActivity, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm) {


    override fun getItemCount(): Int {
        return 2
    }


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                GridFragment()
            } else ->{
                ListFragment()

            }
        }
    }
}