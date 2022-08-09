package com.example.messenger.ui.login

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.messenger.R

class LoginActivity : AppCompatActivity(), LoginView, View.OnClickListener {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bindViews()
    }

    override fun bindViews() {
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        btnSignUp = findViewById(R.id.btn_signup)
        progressBar = findViewById(R.id.progress_bar)
        btnLogin.setOnClickListener(this)
        btnSignUp.setOnClickListener(this)
    }

    override fun showAuthError() {
        Toast.makeText(
            this, "Invalid username and password combination.",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onClick(view: View) {

    }

    override fun getContext(): Context {
        return this
    }

    override fun showProgress() {
        progressBar.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun setUsernameError() {
        etUsername.error = "Username field cannot be empty."
    }

    override fun setPasswordError() {
        etPassword.error = "Password field cannot be empty."
    }

    override fun navigateToSignUp() {
        TODO("Not yet implemented")
    }

    override fun navigateToHome() {
        TODO("Not yet implemented")
    }
}