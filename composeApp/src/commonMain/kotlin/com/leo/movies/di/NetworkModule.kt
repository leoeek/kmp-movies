package com.leo.movies.di

import com.leo.movies.data.network.KtorClient
import org.koin.dsl.module

val networkModule = module {
    single { KtorClient() }
}