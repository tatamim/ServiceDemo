package com.example.servicedemo

import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackgroundService : android.app.Service() {

    init {
        Log.i(TAG, "Service has been created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "Service started")
        val name=intent?.getStringExtra(NAME)
        val marks=intent?.getStringExtra(Marks)
        Log.i(TAG,"name is $name , marks : $marks")
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? = null
    override fun onDestroy() {
        Log.i(TAG, "Destroy.....")
        super.onDestroy()
    }

    companion object{
        const val TAG = "MYTAG"
        const val NAME="Name"
        const val Marks="Total marks"
    }

}

