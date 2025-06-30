package com.leo.movies

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import com.leo.movies.utils.OpenYoutube

fun MainViewController() = ComposeUIViewController {
    CompositionLocalProvider(LocalUrlLauncher provides OpenYoutube()) {
        App()
    }
}