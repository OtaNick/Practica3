package com.angel.practica3

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.angel.practica3.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getPreferences(Context.MODE_PRIVATE)

        var usuarioSP = preferences.getString("usuario","")
        var contrasenyaSP = preferences.getString("contraseña","")

        if (usuarioSP != "" && contrasenyaSP != ""){
            binding.etUsername.setText(usuarioSP)
            binding.etPassword.setText(contrasenyaSP)
        }

        var noticias = Intent(this, NoticiasActivity::class.java)

        loadImageLogin()

        binding.btLogin.setOnClickListener() {
            var usuario = binding.etUsername.text.toString()
            var contraseña = binding.etPassword.text.toString()

            if (usuario != "" && contraseña != ""){
                preferences.edit().putString("usuario",usuario).commit()
                preferences.edit().putString("contraseña",contraseña).commit()
            }
            startActivity(noticias)
        }


    }



    private fun loadImageLogin(url: String = "https://i.pinimg.com/736x/ca/8c/20/ca8c2072504a04004aa11fd06a3ad9a6--wallpaper-iphone-phone-wallpapers.jpg") {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.imgLogin)
    }
}