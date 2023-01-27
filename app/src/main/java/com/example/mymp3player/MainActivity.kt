package com.example.mymp3player

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeMediaPlayerInstance()

        val playButton = findViewById<Button>(R.id.play_btn)
        val pauseButton = findViewById<Button>(R.id.pause_btn)
        val stopButton = findViewById<Button>(R.id.stop_btn)

        playButton.setOnClickListener {
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
                Toast.makeText(this, "Track $it is done!", Toast.LENGTH_SHORT).show()
            }
        }

        pauseButton.setOnClickListener {
            mediaPlayer.pause()
        }

        stopButton.setOnClickListener {
            mediaPlayer.reset()
            initializeMediaPlayerInstance()
        }
    }

    private fun initializeMediaPlayerInstance() {
        mediaPlayer = MediaPlayer.create(this, R.raw.the_sims_3_main_theme)
        mediaPlayer.setVolume(0.5f, 0.5f)
    }
}