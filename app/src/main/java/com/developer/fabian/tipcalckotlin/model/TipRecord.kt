package com.developer.fabian.tipcalckotlin.model

import java.text.SimpleDateFormat
import java.util.*

class TipRecord {
    var bill: Double = 0.0
    var tipPercentage: Double = 0.0
    var timestamp: Date = Date()

    fun getTip(): Double = bill * (tipPercentage / 100)

    fun getDateFormatted(): String {
        val format = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
        return format.format(timestamp)
    }
}
