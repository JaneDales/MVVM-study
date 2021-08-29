package com.janedales.mvvm_first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.janedales.mvvm_first.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
//        viewModel.getTodos()
    }

    private fun init(){
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observe()

        binding.btnMinus.setOnClickListener {
            viewModel.increaseCount(-1)
        }
        binding.btnPlus.setOnClickListener {
            viewModel.increaseCount(1)
        }
    }

    private fun observe(){
        viewModel.counter.observe(this) { number ->
            binding.tvCounter.text = number.toString()
        }
        viewModel.showToast.observe(this) {
            if (it == true){
                Toast.makeText(this , "text", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.list.observe(this) {
            if (it.isNotEmpty()) {
                binding.tvCounter.text = it.toString()
            }
        }
        viewModel.todos.observe(this) {
            binding.tvCounter.text = it.toString()
        }
    }
}