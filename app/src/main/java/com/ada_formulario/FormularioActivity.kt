package com.ada_formulario

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.ada_formulario.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewBinding = ActivityFormularioBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)
        saveInformations()
    }

    private fun saveInformations() {
        prefs.username = viewBinding.etUsername.text.toString()
        prefs.email = viewBinding.etEmail.text.toString()
        prefs.password = viewBinding.etPassword.text.toString().toInt()
        prefs.age = viewBinding.etAge.text.toString()
        prefs.cpf = viewBinding.etCpf.text.toString()
    }
}