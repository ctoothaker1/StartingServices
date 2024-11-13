package com.example.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerService : Service() {
        private val TAG = "TimerService"

        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            val countdownTime = intent?.getIntExtra("countdownTime", 0) ?: 0
            if (countdownTime > 0) {
                startCountdown(countdownTime)
            }
            return START_NOT_STICKY
        }

        private fun startCountdown(time: Int) {
            CoroutineScope(Dispatchers.IO).launch {
                var countdown = time
                while (countdown > 0) {
                    Log.d(TAG, "$countdown seconds remaining")
                    delay(1000)  // 1 second delay
                    countdown--
                }
                Log.d(TAG, "Countdown completed!")
            }
        }

        override fun onBind(intent: Intent?): IBinder? {
            return null // no binding will happen in this assignment
        }
    }

