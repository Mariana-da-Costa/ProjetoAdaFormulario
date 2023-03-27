package com.ada_formulario

import android.app.Application

val prefs: Prefs by lazy { prefs }

class Application: Application()
{
    companion object {
        var prefs: Prefs? = null
        lateinit var instance: Application
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        prefs = Prefs(applicationContext)
    }
}