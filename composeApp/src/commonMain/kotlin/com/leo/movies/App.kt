package com.leo.movies

import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leo.movies.di.dataModule
import com.leo.movies.di.networkModule
import com.leo.movies.di.viewModelModule
import com.leo.movies.navigation.AppRoutes
import com.leo.movies.ui.moviedetail.MovieDetailRoute
import com.leo.movies.ui.movies.MoviesListRoute
import com.leo.movies.ui.theme.MoviesAppTheme
import org.koin.compose.KoinApplication


@Composable
@Preview
fun App() {
    KoinApplication(
        application = {
            modules(
                networkModule,
                dataModule,
                viewModelModule
            )
        }
    ) {
        MoviesAppTheme {
            val navController = rememberNavController()
            NavHost(navController, startDestination = AppRoutes.MoviesList) {
                composable<AppRoutes.MoviesList> {
                    MoviesListRoute(
                        navigateToMovieDetails = { movieId ->
                            navController.navigate(AppRoutes.MovieDetail(movieId))
                        }
                    )
                }

                composable<AppRoutes.MovieDetail> {
                    MovieDetailRoute(
                        navigateBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}