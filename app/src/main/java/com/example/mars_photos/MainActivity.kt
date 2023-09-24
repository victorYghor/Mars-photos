package com.example.mars_photos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mars_photos.overview.OverviewViewModel
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.tvmessage)
        textView.text = viewModel.status.value.toString()
    }

    override fun onResume() {

        super.onResume()
    }
}