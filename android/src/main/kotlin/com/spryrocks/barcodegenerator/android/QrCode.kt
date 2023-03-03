package com.spryrocks.barcodegenerator.android

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import com.spryrocks.barcodegenerator.android.utils.MatrixToImageWriter

class QrCode(
    @Suppress("MemberVisibilityCanBePrivate")
    val value: String,
) {
    private var width: Int = 300
    private var height: Int = 300
    private var errorCorrectionLevel: ErrorCorrectionLevel? = null

    fun withSize(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    fun withErrorCorrection(errorCorrectionLevel: ErrorCorrectionLevel) {
        this.errorCorrectionLevel = errorCorrectionLevel
    }

    fun bitmap(): Bitmap {
        val hints = mutableMapOf<EncodeHintType, Any>().apply {
            errorCorrectionLevel?.let { put(EncodeHintType.ERROR_CORRECTION, it) }
        }
        val matrix = QRCodeWriter().encode(value, BarcodeFormat.QR_CODE, width, height, hints)
        return MatrixToImageWriter.toBitmap(matrix)
    }
}
