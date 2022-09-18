package com.harunkor.netflixclone.presentation.ui

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.harunkor.netflixclone.R
import com.harunkor.netflixclone.databinding.FragmentHomeBinding
import com.harunkor.netflixclone.presentation.mostpopulermovies.MostPopulerMoviesViewModel
import com.harunkor.netflixclone.presentation.mostpopulermovies.adapter.MostPopularMoviesAdapter
import com.harunkor.netflixclone.presentation.mostpopulermovies.adapter.MostPopularMoviesAdapterViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private val mostPopulerMoviesModel by viewModels<MostPopulerMoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        getMostPopulerMovies()
    }

    private fun getMostPopulerMovies(){
        mostPopulerMoviesModel.getMostPopulerMovies().observe(viewLifecycleOwner){ mostPopulerMovies ->
            val mostPopularMoviesAdapter = MostPopularMoviesAdapter(mostPopulerMovies)
            val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.mostPopularMoviesRecyclerview.layoutManager = linearLayoutManager
            binding.mostPopularMoviesRecyclerview.adapter = mostPopularMoviesAdapter

        }

    }

}