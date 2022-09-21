package com.harunkor.netflixclone.presentation.topmovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.harunkor.netflixclone.R
import com.harunkor.netflixclone.domain.model.topmovies.TopMoviesModel

class TopMoviesAdapter (
    private val topMoviesModel: TopMoviesModel
        ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val topMoviesBinding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context),
        R.layout.item_top_movies, parent, false)
            return TopMoviesAdapterViewHolder(topMoviesBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TopMoviesAdapterViewHolder).topMoviesBind(topMoviesModel.items[position])
    }

    override fun getItemCount(): Int {
        return topMoviesModel.items.size.and(10)
    }

}