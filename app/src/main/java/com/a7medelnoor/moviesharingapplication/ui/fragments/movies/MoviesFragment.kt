package com.a7medelnoor.moviesharingapplication.ui.fragments.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.a7medelnoor.moviesharingapplication.R
import com.a7medelnoor.moviesharingapplication.adapters.ViewPagerAdapter
import com.a7medelnoor.moviesharingapplication.databinding.FragmentMoviesBinding
import com.google.android.material.tabs.TabLayoutMediator

class MoviesFragment : Fragment(R.layout.fragment_movies) {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!


    @Nullable
    override fun onCreateView(
        @NonNull inflater: LayoutInflater, @NonNull container: ViewGroup?,
        @NonNull savedInstanceState: Bundle?
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

        val adapter = ViewPagerAdapter(requireActivity(), lifecycle)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
//            Log.d(TAG,"taaab"+tab)
//            Log.d(TAG,"poooo"+position)
            when (position) {
                0 -> {
                    tab.text = "GRID"

                }
                else -> {
                    tab.text = "LIST"
                }
            }
        }.attach()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
