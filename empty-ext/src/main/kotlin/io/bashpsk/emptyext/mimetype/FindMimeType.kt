package io.bashpsk.emptyext.mimetype

import android.webkit.MimeTypeMap

fun findMimeType(extension: String) : String {

    return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension) ?: "*/*"
}