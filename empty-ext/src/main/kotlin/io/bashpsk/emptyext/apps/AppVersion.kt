package io.bashpsk.emptyext.apps

import androidx.compose.runtime.Immutable

@Immutable
data class AppVersion(val name: String = "", val number: Long = 0L)