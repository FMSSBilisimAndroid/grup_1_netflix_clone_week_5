package com.harunkor.netflixclone.presentation.topmovies.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.harunkor.netflixclone.databinding.ItemTopMoviesBinding
import com.harunkor.netflixclone.domain.model.topmovies.TopMoviesItem

class TopMoviesAdapterViewHolder(private val topMoviesBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(topMoviesBinding.root) {

    fun topMoviesBind(topMoviesItem: TopMoviesItem) {
        topMoviesBinding as ItemTopMoviesBinding
        topMoviesBinding.setVariable(BR.topMoviesItem, topMoviesItem)
    }
}