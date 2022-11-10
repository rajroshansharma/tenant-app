package com.android.dev.tenatapp.complaints_section

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.dev.tenatapp.R

class Complaint_first_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint_first)
        supportActionBar?.hide()
    }
}