package com.leo.movies.utils

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual class OpenYoutube {
    actual fun open(url: String) {
        val nsUrl = NSURL.URLWithString(url)
        if (nsUrl != null) {
            UIApplication.sharedApplication.openURL(
                url = nsUrl,
                options = emptyMap<Any?, Any>(),
                completionHandler = null
            )
        }
    }

}