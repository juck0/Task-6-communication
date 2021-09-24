package com.example.task6

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.task6.databinding.FragmentUpBinding
import io.reactivex.rxjava3.core.Observable

class UpFragment : Fragment() {
    private lateinit var binding: FragmentUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_up, container, false)
    }

     fun setData() {
        val observable = Observable.create<String> { emitter ->
            binding.inputText.doOnTextChanged { text,_, _, _ ->
                emitter.onNext(text.toString())
            }
        }
        observable.subscribe({ it ->
            binding.textDown.text = it.toString()
        },
            {
                Log.i("onError", it.message.toString())


            }


        )
    }
    }













