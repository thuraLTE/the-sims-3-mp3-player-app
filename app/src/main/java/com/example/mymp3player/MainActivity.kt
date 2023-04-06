package com.example.mymp3player

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton = findViewById<Button>(R.id.play_btn)
        val pauseButton = findViewById<Button>(R.id.pause_btn)
        val stopButton = findViewById<Button>(R.id.stop_btn)

        playButton.setOnClickListener {
            sendCommandToService(Constants.ACTION_PLAY_MUSIC)
        }

        pauseButton.setOnClickListener {
            sendCommandToService(Constants.ACTION_PAUSE_MUSIC)
        }

        stopButton.setOnClickListener {
            sendCommandToService(Constants.ACTION_STOP_MUSIC)
        }
    }

    private fun sendCommandToService(action: String): Intent {
        intent = Intent(this, MusicPlayingService::class.java)
            .also { intent ->
                intent.action = action
                startService(intent)
            }
        return intent
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(intent)
    }
}