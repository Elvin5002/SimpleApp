package com.elvin.simpleapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.elvin.simpleapp.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
private var runnable:Runnable = Runnable{}
private var handler : Handler = Handler(Looper.getMainLooper())
var number = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun rool(view: View){
        //val random = (1..6).random()
        val dice1 = rand(6)
        val dice2 = rand(6)

        val drawableResource1 = when(dice1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when(dice2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        binding.dice1.setImageResource(drawableResource1)
        binding.dice2.setImageResource(drawableResource2)


    }

    fun rand(num: Int): Int{
        return (1..num).random()
    }

    fun reset(view: View){
        binding.dice1.setImageResource(R.drawable.dice_1)
        binding.dice2.setImageResource(R.drawable.dice_1)
    }
/*
    fun start(view: View){
        number = 0
        runnable = object : Runnable{
            override fun run() {
                number++
                binding.textView.text = "Time: $number"
                handler.postDelayed(this,1000)
            }
        }
        handler.post(runnable)
        binding.start.isEnabled = false
    }

    fun stop(view: View){
        handler.removeCallbacks(runnable)
        number = 0
        binding.textView.text = "Time: $number"
        binding.start.isEnabled = true

    }*/
}

class Dice(private val num: Int){
    fun roll(): Int{
        return (1..num).random()
    }
}