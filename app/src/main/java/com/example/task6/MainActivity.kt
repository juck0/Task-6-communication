package com.example.task6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged

import com.example.task6.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var observable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
    }


    private fun setData() {
        val observable = Observable.create<String> { emitter ->
            binding.inputText.doOnTextChanged { text, start, before, count ->
                emitter.onNext(text.toString())
            }
        }
        observable.subscribe() { it ->
            binding.textDown.text = it.toString()
        }


    }


}