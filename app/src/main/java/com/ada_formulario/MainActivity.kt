package com.ada_formulario

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ada_formulario.FormularioActivity.Companion.EMAIL
import com.ada_formulario.FormularioActivity.Companion.KEEP_CONNECTED_PREFS
import com.ada_formulario.FormularioActivity.Companion.PASSWORD
import com.ada_formulario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        val preferences = getSharedPreferences(KEEP_CONNECTED_PREFS, MODE_PRIVATE)
        val email = preferences.getString(EMAIL, "")
        val password = preferences.getString(PASSWORD, "")

        viewBinding.editTEmailMain.hint = email
        viewBinding.editTPasswordMain.hint = password

        viewBinding.btnLoginMain.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }
    }
}