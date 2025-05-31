package io.bashpsk.emptyext.apps

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.content.pm.PackageInfoCompat

fun getAppVersion(context: Context): AppVersion {

    return try {

        val packageManager = context.packageManager
        val packageName = context.packageName

        val packageInfo = when {

            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> packageManager.getPackageInfo(
                packageName,
                PackageManager.PackageInfoFlags.of(0)
            )

            else -> packageManager.getPackageInfo(packageName, 0)
        }

        AppVersion(
            name = packageInfo.versionName ?: "",
            number = PackageInfoCompat.getLongVersionCode(packageInfo),
        )
    } catch (exception: Exception) {

        Log.e("EMPTY-EXT", exception.message, exception)
        AppVersion()
    }
}