package com.digitalrelay.materialplayground

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate



class RootApp : Application() {
    companion object {
        var ctx: Context? = null
    }

    init {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
    }
}