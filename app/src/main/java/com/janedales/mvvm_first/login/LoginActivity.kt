package com.janedales.mvvm_first.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.janedales.mvvm_first.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }
    private fun init(){
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        observe()

        binding.btnLogin.setOnClickListener{
            viewModel.validate(binding.etUserName.text.toString(), binding.etPassword.text.toString())
        }
    }
    private fun observe(){
        viewModel.error.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        viewModel.successLogin.observe(this){
            Toast.makeText(this , "Successful registration", Toast.LENGTH_SHORT).show()
        }
    }
}