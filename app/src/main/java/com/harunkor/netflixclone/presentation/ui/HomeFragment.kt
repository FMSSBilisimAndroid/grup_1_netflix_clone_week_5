package com.harunkor.netflixclone.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.harunkor.netflixclone.R
import com.harunkor.netflixclone.databinding.FragmentHomeBinding
import com.harunkor.netflixclone.presentation.mostpopulermovies.MostPopulerMoviesViewModel
import com.harunkor.netflixclone.presentation.mostpopulermovies.adapter.MostPopularMoviesAdapter
import com.harunkor.netflixclone.presentation.topmovies.TopMoviesViewModel
import com.harunkor.netflixclone.presentation.topmovies.adapter.TopMoviesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val mostPopulerMoviesViewModel: MostPopulerMoviesViewModel by viewModels()
    private val topMoviesViewModel: TopMoviesViewModel by viewModels()

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
        getTopMovies()
    }

    private fun getMostPopulerMovies() {
        mostPopulerMoviesViewModel.getMostPopulerMovies()
            .observe(viewLifecycleOwner) { mostPopulerMovies ->
                val mostPopularMoviesAdapter = MostPopularMoviesAdapter(mostPopulerMovies)
                val linearLayoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.mostPopularMoviesRecyclerview.layoutManager = linearLayoutManager
                binding.mostPopularMoviesRecyclerview.adapter = mostPopularMoviesAdapter

            }

        mostPopulerMoviesViewModel.getMostPopulerMovies()
            .observe(viewLifecycleOwner) { mostPopulerMovies ->
                val mostPopularMoviesAdapter = MostPopularMoviesAdapter(mostPopulerMovies)
                val linearLayoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.mostPopularMoviesRecyclerview2.layoutManager = linearLayoutManager
                binding.mostPopularMoviesRecyclerview2.adapter = mostPopularMoviesAdapter

            }
    }

    private fun getTopMovies() {
        topMoviesViewModel.getTopMovies().observe(viewLifecycleOwner) { topMovies ->
            val topMoviesAdapter = TopMoviesAdapter(topMovies)
            val linearLayoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.topMoviesRecyclerview.layoutManager = linearLayoutManager
            binding.topMoviesRecyclerview.adapter = topMoviesAdapter
        }

        topMoviesViewModel.getTopMovies().observe(viewLifecycleOwner) { topMovies ->
            val topMoviesAdapter = TopMoviesAdapter(topMovies)
            val linearLayoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.topMoviesRecyclerview2.layoutManager = linearLayoutManager
            binding.topMoviesRecyclerview2.adapter = topMoviesAdapter
        }
    }


}