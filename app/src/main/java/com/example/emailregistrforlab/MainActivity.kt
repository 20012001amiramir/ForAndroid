package com.example.emailregistrforlab

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern


@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {
    val APP_PREFERENCES = "mysettings"
    val APP_PREFERENCES_NAME = "res"
    val APP_PREFERENCES_PASS = "password"
    private var username: EditText? = null
    private var password: EditText? = null
    private var login: Button? = null
    var mSettings: SharedPreferences? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        username = findViewById<EditText>(R.id.edit_mail)
        password = findViewById<EditText>(R.id.edit_password)
        login = findViewById<Button>(R.id.buttonlogin)
    }
    fun isPassValid(email: String): Boolean {
        return Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#${'$'}%!\\-_?&]).{6,}"
                     ).matcher(email).matches()
    }
    fun isEmailValid(pass: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(pass).matches()
    }
    fun Check(a: String, b: String, c: List<String>, d: List<String>): Boolean {
        if(c.contains(a) && d.contains(b))
        {
            if(c.indexOf(a) == d.indexOf(b))
            {
                return true;
            }
        }
        return false

    }
    public fun Login(view: View?) {

        var passworda = password!!.text.toString()
        var usernamea = username!!.text.toString()
        var passwrodss: List<String> = listOf("K$8YArac", "L3@gSafn", "Amir4@")
        var usernamess: List<String> =
            listOf("20012001amiramir@gmail.com", "jdjdidkekeke@gmail.com", "adminer@gmail.com")
        if (mSettings!!.contains(APP_PREFERENCES_NAME)) {
            edit_mail.setText(mSettings!!.getString(APP_PREFERENCES_NAME, ""));
            edit_password.setText(mSettings!!.getString(APP_PREFERENCES_PASS, ""));
            if (Check(edit_mail.getText().toString(), edit_password.getText().toString(), usernamess, passwrodss)) {
                Toast.makeText(
                    applicationContext,
                    "Вход выполнен!",
                    Toast.LENGTH_SHORT
                ).show()
                val editor: SharedPreferences.Editor = mSettings!!.edit()
                editor.putString(APP_PREFERENCES_NAME, usernamea)
                editor.apply()

                val intent = Intent(this, RegistrOk::class.java)
                startActivity(intent)
            } else if (!isEmailValid(usernamea)) {
                Toast.makeText(
                    applicationContext,
                    "email имеет неверный формат",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (!isPassValid(passworda)) {
                Toast.makeText(
                    applicationContext,
                    "Пароль имеет неверный формат",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (Check(usernamea, passworda, usernamess, passwrodss)) {
                Toast.makeText(
                    applicationContext,
                    "Вход выполнен!",
                    Toast.LENGTH_SHORT
                ).show()
                val editor: SharedPreferences.Editor = mSettings!!.edit()
                editor.putString(APP_PREFERENCES_NAME, usernamea)
                editor.apply()

                val intent = Intent(this, RegistrOk::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    applicationContext,
                    "Вход невыполнен!",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
}