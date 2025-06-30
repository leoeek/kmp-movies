package com.leo.movies.utils

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

actual class OpenYoutube(private val context: Context) {
    actual fun open(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
        context.startActivity(intent)
    }
}