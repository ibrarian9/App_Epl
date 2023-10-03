package com.app.submissionakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val backBtn: ImageView = findViewById(R.id.ivBack)
        backBtn.setOnClickListener{
            startActivity(Intent(this@AboutActivity, MainActivity::class.java))
        }
    }
}