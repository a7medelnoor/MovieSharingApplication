package com.a7medelnoor.moviesharingapplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.a7medelnoor.moviesharingapplication.ui.fragments.movies.MoviesFragment
import com.a7medelnoor.moviesharingapplication.ui.fragments.movies.searchmovie.SearchMovieFragment

public class ViewPagerAdapter(
    fm: FragmentManager
) :
    FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {

        return when (position) {
          0 -> {
              MoviesFragment()
          } else ->{
                SearchMovieFragment()

            }
        }
    }
//    override fun getCount(): Int {
//        return 2
//    }
    override fun getPageTitle(position: Int): CharSequence? {
    return when (position) {
        0 -> "GRID"
        else -> {
            return "LIST"
        }
    }


}
    }