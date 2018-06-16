package com.developer.fabian.tipcalckotlin

import android.app.Application

class TipCalcApplication : Application() {

    companion object {
        const val ABOUT_URL: String = "https://github.com/FabianVarela"
    }

    fun getAboutUrl(): String {
        return ABOUT_URL
    }
}
