package com.a7medelnoor.moviesharingapplication.ui.fragments.movies.grid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.a7medelnoor.moviesharingapplication.R
import com.a7medelnoor.moviesharingapplication.adapters.GridRecyclerViewAdapter
import com.a7medelnoor.moviesharingapplication.databinding.FragmentGridBinding
import com.a7medelnoor.moviesharingapplication.ui.hide
import com.a7medelnoor.moviesharingapplication.ui.show
import com.a7medelnoor.moviesharingapplication.util.NetWorkResult
import com.a7medelnoor.moviesharingapplication.viewModel.MainViewModel
import com.a7medelnoor.moviesharingapplication.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_grid.view.*

@AndroidEntryPoint
class GridFragment : Fragment(R.layout.fragment_grid) {
    private  val TAG = "GridFragment"
    private var _binding :FragmentGridBinding? = null
    private val binding get() = _binding!!
    private lateinit var moviesViewModels : MoviesViewModel
    private lateinit var mainViewModels : MainViewModel
    private val gridRecyclerViewAdapter= GridRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moviesViewModels = ViewModelProvider(requireActivity()).get(MoviesViewModel::class.java)
        mainViewModels = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }
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
        setupRecyclerView()
        requestDataFromAPI()
        return binding.root
    }

    private fun requestDataFromAPI() {
            moviesViewModels.getMovies(mainViewModels.applyQueries())
            moviesViewModels._gridListResponse.observe(viewLifecycleOwner, { response ->
                Log.d(TAG,response.toString())

                when(response){
                    is NetWorkResult.SUCCESS -> {
                        binding.progressBr.hide()
                        response.data?.let { gridRecyclerViewAdapter.setData(it) }
                    }
                    is NetWorkResult.ERROR -> {
                        binding.progressBr.hide()
                        Toast.makeText(
                            requireContext(),
                            response.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    is NetWorkResult.LOADING -> {
                        binding.progressBr.show()
                    }
                }

            })


    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
            recyclerView.layoutManager = layoutManager
            adapter=gridRecyclerViewAdapter
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}