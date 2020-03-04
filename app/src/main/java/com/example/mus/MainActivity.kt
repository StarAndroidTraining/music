package com.example.mus

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mus.R

class MainActivity : AppCompatActivity() {

    private lateinit var mp:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mp = MediaPlayer.create(this, R.raw.sampleaudio)
        var position = 0
        val button1 = findViewById(R.id.buttonl) as Button
        val button2 = findViewById(R.id.button2) as Button
        val button3 =findViewById(R.id.button3) as Button
        button1.setOnClickListener {
            mp.start()
            if (button1.text == "Do not play in a circular way")
                mp.isLooping = false
            else
                mp.isLooping = true
        }
        button2.setOnClickListener {
            if (mp.isPlaying()) {
                position = mp.getCurrentPosition()
                mp.pause()
            }

        }
        button3.setOnClickListener{
            mp.start()
            mp.isLooping=true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.release()
    }
}
