package io.bashpsk.emptyext.apps

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.net.toUri

fun appOpenGooglePlay(context: Context, appPackage: String) {

    try {

        Intent(Intent.ACTION_VIEW, "market://details?id=$appPackage".toUri()).apply {

            setPackage("com.android.vending")
        }.also { intent ->

            context.startActivity(intent)
        }
    } catch (_: ActivityNotFoundException) {

        Intent(
            Intent.ACTION_VIEW,
            "https://play.google.com/store/apps/details?id=$appPackage".toUri()
        ).also { intent ->

            context.startActivity(intent)
        }
    } catch (exception: Exception) {

        Log.e("EMPTY-EXT",exception.message, exception)
    }
}