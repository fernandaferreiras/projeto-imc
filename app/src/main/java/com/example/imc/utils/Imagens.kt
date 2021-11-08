package com.example.imc.utils

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream

fun convertBitmapToBase64(bitmap: Bitmap) : String {
    val bitmapArray = ByteArrayOutputStream()

    bitmap.compress(
        Bitmap.CompressFormat.JPEG,
        100,
        bitmapArray)

    return Base64.encodeToString(
        bitmapArray.toByteArray(),
        Base64.DEFAULT)

}
