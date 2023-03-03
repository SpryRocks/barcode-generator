package com.spryrocks.barcodegenerator.android

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.oned.EAN13Writer
import com.spryrocks.barcodegenerator.android.utils.MatrixToImageWriter

class Ean13(
    @Suppress("MemberVisibilityCanBePrivate")
    val value: String,
) {
    private var width: Int = 600
    private var height: Int = 200

    fun withSize(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    fun bitmap(): Bitmap {
        val matrix = EAN13Writer().encode(value, BarcodeFormat.EAN_13, width, height)
        return MatrixToImageWriter.toBitmap(matrix)
    }
}
