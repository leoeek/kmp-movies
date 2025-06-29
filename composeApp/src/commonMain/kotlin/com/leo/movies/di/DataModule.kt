package com.leo.movies.di

import com.leo.movies.data.repository.MoviesRepository
import org.koin.dsl.module

val dataModule = module {
    factory {
        MoviesRepository(get())
    }
}