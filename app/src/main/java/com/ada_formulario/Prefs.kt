package com.ada_formulario

import android.content.SharedPreferences
import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class Prefs(context: Context) {
    private val USERNAME = "username"
    private val EMAIL = "email"
    private val PASSWORD = "password"
    private val AGE = "age"
    private val CPF = "cpf"
    private val DEFAULT_USER = "default_user"
    private val APP_PREFS = "prefs"
    private val preferences: SharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE)

    private val mainKeyAlias by lazy {
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        MasterKeys.getOrCreate(keyGenParameterSpec)
    }

    private val encryptedSharedPrefs by lazy {
        val sharedPrefsFile = "EncryptPref"

        EncryptedSharedPreferences.create(
            sharedPrefsFile,
            mainKeyAlias,
            context.applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    var username: String?
        get() = preferences.getString(USERNAME, "")
        set(value) = preferences.edit().putString(USERNAME, value).apply()

    var email: String?
        get() = preferences.getString(EMAIL, "")
        set(value) = preferences.edit().putString(EMAIL, value).apply()

    var password: Int
        get() = encryptedSharedPrefs.getInt(PASSWORD, 0)
        set(value) = encryptedSharedPrefs.edit().putInt(PASSWORD, value).apply()

    var age: String?
        get() = preferences.getString(AGE, "")
        set(value) = preferences.edit().putString(AGE, value).apply()

    var cpf: String?
        get() = preferences.getString(CPF, "")
        set(value) = preferences.edit().putString(CPF, value).apply()

    var default_user: Boolean
        get() = preferences.getBoolean(DEFAULT_USER, false)
        set(value) = preferences.edit().putBoolean(DEFAULT_USER, value).apply()
}