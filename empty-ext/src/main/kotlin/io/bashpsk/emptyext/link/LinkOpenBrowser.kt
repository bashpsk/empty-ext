package io.bashpsk.emptyext.link

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.net.toUri

fun linkOpenBrowser(context: Context, link: String) {

    try {

        val intent = Intent(Intent.ACTION_VIEW, link.toUri())

        context.startActivity(Intent.createChooser(intent, "Open link with..."))
    } catch (exception: Exception) {

        Log.e("EMPTY-EXT", exception.message, exception)
    }
}