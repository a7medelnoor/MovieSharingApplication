package com.a7medelnoor.moviesharingapplication.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.a7medelnoor.moviesharingapplication.ui.fragments.ListMoviesFragment;
import com.a7medelnoor.moviesharingapplication.ui.fragments.favorites.FavoritesFragment;
import com.a7medelnoor.moviesharingapplication.ui.fragments.movies.MoviesFragment;
import com.a7medelnoor.moviesharingapplication.ui.fragments.movies.searchmovie.SearchMovieFragment;

import org.jetbrains.annotations.NotNull;

public class ViewPagerAdapterJava extends FragmentStateAdapter {
    public ViewPagerAdapterJava(  FragmentManager fm,Lifecycle  lifecycle) {
        super(fm, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
      switch (position){
          case 0:
              return new MoviesFragment();
          case 1:
              return  new ListMoviesFragment();
      }
      return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}