package com.a7medelnoor.moviesharingapplication.ui.fragments.movies.grid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.a7medelnoor.moviesharingapplication.R
import com.a7medelnoor.moviesharingapplication.adapters.GridRecyclerViewAdapter
import com.a7medelnoor.moviesharingapplication.databinding.FragmentGridBinding
import com.a7medelnoor.moviesharingapplication.ui.hide
import com.a7medelnoor.moviesharingapplication.ui.show
import com.a7medelnoor.moviesharingapplication.util.Resources
import com.a7medelnoor.moviesharingapplication.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_grid.view.*

@AndroidEntryPoint
class GridFragment : Fragment(R.layout.fragment_grid) {
    private  val TAG = "GridFragment"
    private var _binding :FragmentGridBinding? = null
    private val binding get() = _binding!!
    private val moviesViewModels by viewModels<MoviesViewModel> ()
    private val gridRecyclerViewAdapter= GridRecyclerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGridBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
            recyclerView.layoutManager = layoutManager
            adapter=gridRecyclerViewAdapter
         }
        moviesViewModels.gridListItemLiveData.observe(viewLifecycleOwner, { result ->
            if(result != null) {
                Log.d(TAG, "onViewCreated: "+result)
            }
            when(result) {
               is Resources.ERROR -> {
                   binding.progressBr.hide()
               }
             Resources.LOADING -> {binding.progressBr.show()}
               is Resources.SUCCESS -> {
                   binding.progressBr.hide()
                   gridRecyclerViewAdapter.items = result.value
                   Log.d(TAG, "onViewCreated: "+gridRecyclerViewAdapter.items)
               }
           }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}