package com.example.unit_3_coding_evalution_2

import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.IBinder
import android.view.LayoutInflater
import androidx.core.app.NotificationCompat

class MusicService : Service() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var url: String
    private val channelId = "Music Playing Notification"

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
        showNotificationAndStartForeGround()
        mediaPlayer = MediaPlayer()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            url = intent.getStringExtra("song").toString()
        }
        playMusic()
        return super.onStartCommand(intent, flags, startId)

    }

    private fun playMusic() {
        mediaPlayer.reset()
        val uri = Uri.parse(url)
        mediaPlayer = MediaPlayer.create(applicationContext, uri)
        mediaPlayer.start()
    }

    private fun showNotificationAndStartForeGround(): Int {
        createChannel();
        val notificationIntent = Intent(this, MusicPlayActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val notification: Notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Music Playing")
            .setContentText("Music Playing")
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)
        return START_NOT_STICKY
    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Music Playing",
                NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.description = "Music Notifications";
            (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(
                channel
            );
        }
    }
}