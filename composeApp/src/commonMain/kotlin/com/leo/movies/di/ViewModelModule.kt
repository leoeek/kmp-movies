package com.leo.movies.di

import com.leo.movies.ui.moviedetail.MovieDetailViewModel
import com.leo.movies.ui.movies.MoviesListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MoviesListViewModel(get())
    }
    viewModel {
        MovieDetailViewModel(get(), get())
    }
}