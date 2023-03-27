package com.ada_formulario

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ada_formulario.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityFormularioBinding

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityFormularioBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)
        recoverInformation()
        saveInformation()
    }

    private fun recoverInformation() {
        val preferences: SharedPreferences =
            getSharedPreferences(KEEP_CONNECTED_PREFS, MODE_PRIVATE)

        val username = preferences.getString(USERNAME, "")
        val email = preferences.getString(EMAIL, "")
        val password = preferences.getString(PASSWORD, "")
        val age = preferences.getString(AGE, "")
        val cpf = preferences.getString(CPF, "")

        viewBinding.etUsername.hint = username
        viewBinding.etEmail.hint = email
        viewBinding.etPassword.hint = password
        viewBinding.etAge.hint = age
        viewBinding.etCpf.hint = cpf
    }

    private fun saveInformation() {
        val preferences: SharedPreferences =
            getSharedPreferences(KEEP_CONNECTED_PREFS, MODE_PRIVATE)

        viewBinding.btnSave.setOnClickListener {
            preferences.edit()
                .putString(USERNAME, viewBinding.etUsername.text.toString())
                .putString(EMAIL, viewBinding.etEmail.text.toString())
                .putString(PASSWORD, viewBinding.etPassword.text.toString())
                .putString(AGE, viewBinding.etAge.text.toString())
                .putString(CPF, viewBinding.etCpf.text.toString())
                .apply()
        }
    }

    companion object {
        const val USERNAME = "username"
        const val EMAIL = "email"
        const val PASSWORD = "password"
        const val AGE = "age"
        const val CPF = "cpf"
        const val KEEP_CONNECTED_PREFS = "SAVE_LOGIN_PREFERENCES"
    }
}