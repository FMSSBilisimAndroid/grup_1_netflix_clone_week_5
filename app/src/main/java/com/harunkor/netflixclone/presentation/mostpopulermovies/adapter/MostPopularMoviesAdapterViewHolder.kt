package com.harunkor.netflixclone.presentation.mostpopulermovies.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.harunkor.netflixclone.databinding.DefaultItemRowBinding
import com.harunkor.netflixclone.domain.model.mostpopulermovies.MostPopularMoviesItem

class MostPopularMoviesAdapterViewHolder(private val mostPopularMoviesBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(mostPopularMoviesBinding.root) {

    fun MostPopulerMoviewAdapterBind(mostPopularMoviesItem: MostPopularMoviesItem) {
        val mostPopularMoviesBinding = mostPopularMoviesBinding as DefaultItemRowBinding
        mostPopularMoviesBinding.setVariable(BR.mostPopulerMoviesItem, mostPopularMoviesItem)


    }
}