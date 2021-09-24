package com.example.task6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doOnTextChanged
import com.example.task6.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Observable


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
     val upFragment = UpFragment()
    val downFragment = DownFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        upFragment.setData()
        trans()
    }

    private fun trans() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_up,upFragment)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_down,downFragment)

    }



}