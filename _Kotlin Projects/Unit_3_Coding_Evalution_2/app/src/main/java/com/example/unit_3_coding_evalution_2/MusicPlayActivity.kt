package com.example.unit_3_coding_evalution_2

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.StartElementListener
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_music_play.*
import java.net.URI

class MusicPlayActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var url: String
    var pause = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_play)
        supportActionBar?.hide()
        mediaPlayer = MediaPlayer()
        getIntentData()

        val intent  = Intent(this, MusicService::class.java)
        intent.putExtra("song", url)
        ivPlayPause.setOnClickListener {
            if(pause) {
                stopService(intent)
                pause = false
                ivPlayPause.setImageResource(R.drawable.play)
            } else {
                startService(intent)
                pause = true
                ivPlayPause.setImageResource(R.drawable.pause)
            }
        }
    }

    private fun getIntentData() {
        tvTrackName.text = intent.getStringExtra("trackName")
        tvArtistName.text = intent.getStringExtra("artistName")
        tvCollectionName.text = intent.getStringExtra("collectionName")
        Glide.with(this).load(intent.getStringExtra("image")).into(ivImage)
        url = intent.getStringExtra("song").toString()
        Log.d("Abhishek", url)
    }
}