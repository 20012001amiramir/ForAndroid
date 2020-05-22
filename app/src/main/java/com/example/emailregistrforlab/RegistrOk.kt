package com.example.emailregistrforlab

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RegistrOk : AppCompatActivity() {
    val APP_PREFERENCES = "mysettings"
    val APP_PREFERENCES_NAME = "email"
    val APP_PREFERENCES_AGE = "password"
    var mSettings: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registr_ok)
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

    }
    @SuppressLint("CommitPrefEdits")
    fun Exit(view: View)
    {
        mSettings!!.edit().clear();
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}

