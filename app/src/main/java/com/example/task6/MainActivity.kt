package com.example.task6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        //setData()
        trans()
    }

    private fun trans() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_up,upFragment)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_down,downFragment)

    }


//    private fun setData() {
//        val observable = Observable.create<String> { emitter ->
//            binding.inputText.doOnTextChanged { text,_, _, _ ->
//                emitter.onNext(text.toString())
//            }
//        }
//        observable.subscribe() { it ->
//            binding.textDown.text = it.toString()
//        }
//    }
}