package com.example.servicedemo

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.servicedemo.MyBackgroundService.Companion.Marks
import com.example.servicedemo.MyBackgroundService.Companion.NAME
import com.example.servicedemo.MyBackgroundService.Companion.TAG
import com.example.servicedemo.databinding.MainActivityBinding
import com.example.servicedemo.ui.theme.ServiceDemoTheme

class MainActivity : ComponentActivity() {
    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val serviceIntent= Intent(this,MyBackgroundService::class.java)
        serviceIntent.putExtra(NAME,"Alex")
        serviceIntent.putExtra(Marks,78)
        binding.btnStart.setOnClickListener {
            Log.i(TAG,"Service started")
            startService(serviceIntent)
        }
        binding.btnStop.setOnClickListener {
            Log.i(TAG,"Service stoped")
            stopService(serviceIntent)
        }

    }
}